package com.keshav.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value={"value3"})
public class SomeObj {
	
	public String value1;
	public String value2;
	@JsonIgnore
	public String value3;
	
	public SomeObj(String value1, String value2, String value3) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

}
