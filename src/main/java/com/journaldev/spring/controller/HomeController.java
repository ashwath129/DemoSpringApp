package com.journaldev.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;

import com.journaldev.spring.model.User;

@Controller
public class HomeController {
	private static final Logger log = Logger.getLogger(HomeController.class.getName());

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		String numerator = user.getNum();
		int numeratorInt = Integer.parseInt(numerator);
		System.out.println(numeratorInt);
		try {
			int quotient = numeratorInt/0;	
		}
		catch (Exception e) {
	           System.out.println(e);
            	   log.error(e.getMessage());
            	   StringWriter writer = new StringWriter();
                   PrintWriter pw = new PrintWriter(writer);
                   e.printStackTrace(pw);
            	   log.error(writer.toString());
               }
		
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
}
