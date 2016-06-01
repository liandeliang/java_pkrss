package com.pkrss.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.pkrss.server.domain.RssLocale;
import com.pkrss.server.helper.RssLocaleHelper;

@Controller
@RequestMapping("/home")
public final class HomeController {
	
    @RequestMapping(method = { RequestMethod.GET })
    public String index(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(value="uilang",defaultValue="en",required=false) String uiLang) {
    	
    	RssLocale rssLocale = RssLocaleHelper.getInstance().getBySimilayLocale(uiLang);
    	if(rssLocale == null)
    		RssLocaleHelper.getInstance().getDefaultLocale();
    	
    	Integer lid = com.pkrss.server.constant.ServerConstants.Locale.defaultLid;
    	if(rssLocale != null)
    		lid = rssLocale.getId();
    	
    	return "redirect:home/msnry?lid=" + lid;
    }
    
    @RequestMapping(method = { RequestMethod.GET }, value="/msnry")
    public String msnry(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("seolist", "haha,");
    	return "home/msnry";
    }
}
