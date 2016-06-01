package com.pkrss.server.filter;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkrss.server.domain.RssLocale;
import com.pkrss.server.helper.RssLocaleHelper;

public final class LocaleFilter implements org.springframework.web.servlet.LocaleResolver {
	
	private Locale userBrowserLocal;
	
    @Override
	public Locale resolveLocale(HttpServletRequest request) {
    	
    	RssLocaleHelper rssLocaleHelper = RssLocaleHelper.getInstance();
    	
    	RssLocale rssLocale = null;
    	
    	String s = request.getParameter("lid");
    	if(s != null && s.length()>0)	
    		rssLocale = rssLocaleHelper.getById(Integer.parseInt(s));
    	
    	if(rssLocale != null){
	    	String lang = "";
	    	String country = "";
	    	
	    	s = rssLocale.getLocale();
	    	int pos = s.indexOf('_');
	    	if(pos > 0){
	    		lang = s.substring(0,pos);
	    		country = s.substring(pos+1);
	    	}
	    	
	    	userBrowserLocal = new Locale(lang, country);
    	}else{
    		userBrowserLocal = Locale.ENGLISH;
    	}
    	
    	return userBrowserLocal;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		userBrowserLocal = locale;
	}
}
