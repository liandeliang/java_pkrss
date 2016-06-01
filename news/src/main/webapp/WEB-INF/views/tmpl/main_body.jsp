<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pkrss.server.helper.RssLocaleHelper" %>
<%@ page import="com.pkrss.server.domain.RssLocale" %>
<%
	RssLocale rssLocale = RssLocaleHelper.getInstance().getCurrentRssLocale(request);
	if(rssLocale!=null)
		out.println("<body lang=\"" + rssLocale.getLocale() + "\">");
	else
		out.println("<body>");
%>