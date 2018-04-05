package com.keshav.webservice.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.keshav.webservice.dao.UserRepository;
import com.keshav.webservice.model.User;

@Controller
public class HomeController {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "UserId,UserName,DOB";
	 
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public ModelAndView getHomePage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/exportuserlist.bin")
	public ModelAndView loadUserCsvData(HttpServletRequest request, HttpServletResponse response) {
		String dateString="";
		List<User> users = userRepository.findAll();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			dateString = formatter.format(new Date());
			String csv = createCSV(users);
			response.setHeader("Content-Disposition","attachment;filename=UserList_"+dateString+".csv");
			response.setContentType("text/csv");
			response.setContentLength(csv.getBytes().length);
			response.getWriter().write(csv);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String createCSV(List<User> userList) {
		String csvdata="";
		StringBuilder fileWriter=new StringBuilder();
		fileWriter.append(FILE_HEADER);
		fileWriter.append(NEW_LINE_SEPARATOR);  
		for(User user: userList) {
			fileWriter.append(user.getUserId());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(user.getUserName());
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(user.getDob());

			fileWriter.append(NEW_LINE_SEPARATOR);
		}
		csvdata = fileWriter.toString();
		return csvdata;
	}
}
