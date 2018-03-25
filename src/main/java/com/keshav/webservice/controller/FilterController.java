package com.keshav.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.webservice.model.SomeObj;

@RestController
public class FilterController {

	@GetMapping("/someData")
	public SomeObj getSomeData() {
		return new SomeObj("25","keshav","gowda");
	}
	
	@GetMapping("/filtered")
	public List<SomeObj> getFilteredData() {
		List<SomeObj> objs = new ArrayList<>();
		objs.add(new SomeObj("25","keshav","gowda"));
		objs.add(new SomeObj("26","rashmi","lakshman"));
		objs.add(new SomeObj("25","smitha","ramesh"));
		return objs;
	}
}
