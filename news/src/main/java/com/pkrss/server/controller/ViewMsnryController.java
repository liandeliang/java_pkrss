package com.pkrss.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewMsnry")
public final class ViewMsnryController {
	
	@RequestMapping(method = { RequestMethod.GET })
    public String index(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("seolist", "haha");
    	return "viewMsnry";
    }
	
}
