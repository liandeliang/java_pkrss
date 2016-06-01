package com.pkrss.server.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pkrss.server.constant.ServerConstants;
import com.pkrss.server.domain.RssLocale;

public final class RssLocaleHelper {
	
	//////////////////////////////////////////////////////////
	// get instance
	
	private static RssLocaleHelper instance;
	
	public static RssLocaleHelper getInstance(){
		if(instance == null)
			instance = new RssLocaleHelper();
		return instance;
	}
	
	// get instance
	//////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////
	// get locales
	
	private List<RssLocale> rssLocales;

	public List<RssLocale> getRssLocales() {
		return rssLocales;
	}

	public void setRssLocales(List<RssLocale> rssLocales) {
		this.rssLocales = rssLocales;
	}
	
	// get locales
	//////////////////////////////////////////////////////////

	
	//////////////////////////////////////////////////////////
	// get current locale info

	public RssLocale getCurrentRssLocale(HttpServletRequest request) {
		RssLocale ret = (RssLocale) request.getAttribute("currentRssLocale");
		if(ret != null)
			return ret;
		
		String s = request.getParameter("lid");
		Integer lid = ServerConstants.Locale.defaultLid;
		if((s != null) && (s.length()>0))
			lid = Integer.parseInt(s);

		ret = getById(lid);
		if(ret == null)
	    	ret = getDefaultLocale();
		
		request.setAttribute("currentRssLocale", ret);
		
		return ret;
	}
	
    public RssLocale getById(Object id) {
    	if(rssLocales == null)
    		return null;
    	for(RssLocale rssLocale : rssLocales){
    		if(rssLocale.getId().equals(id))
    			return rssLocale;
    	}
        return null;
    }
	
    public RssLocale getBySimilayLocale(String locale) {
    	
    	if((locale == null) || (locale.length()==0) || (rssLocales == null) || (rssLocales.size()==0))
    		return null;
    	
    	locale = locale.replace('-', '_');
    	for(RssLocale rssLocale : rssLocales){
    		if(rssLocale.getLocale().equals(locale))
    			return rssLocale;
    	}
    	
    	int pos = locale.indexOf('_');
    	if(pos>0)
    		locale = locale.substring(0, pos);
    	
    	for(RssLocale rssLocale : rssLocales){
    		String s = rssLocale.getLocale();
    		pos = s.indexOf('_');
        	if(pos>0)
        		s = s.substring(0, pos);
    		if(s.equals(locale))
    			return rssLocale;
    	}
		
        return null;
    }
    
    public RssLocale getDefaultLocale() {
    	if((rssLocales!=null) && (rssLocales.size()>0)){
	    	return rssLocales.get(0);
		}
    	return null;
    }
    
	// get locales
	//////////////////////////////////////////////////////////
	
}
