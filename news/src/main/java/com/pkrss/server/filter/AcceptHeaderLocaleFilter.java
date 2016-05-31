package com.pkrss.server.filter;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class AcceptHeaderLocaleFilter extends org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver {
	
	private Locale userBrowserLocal;
	
    @Override
	public Locale resolveLocale(HttpServletRequest request) {
    	userBrowserLocal = request.getLocale();
    	
    	return userBrowserLocal;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		userBrowserLocal = locale;
	}
}
