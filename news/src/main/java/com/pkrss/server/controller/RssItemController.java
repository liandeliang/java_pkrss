package com.pkrss.server.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pkrss.server.constant.ServerConstants;
import com.pkrss.server.domain.RssItem;
import com.pkrss.server.http.response.BasePageResponse;
import com.pkrss.server.http.response.BaseResponse;
import com.pkrss.server.http.response.EmptyResponse;
import com.pkrss.server.secure.PreAuthorize;

@Controller
@RequestMapping("/rssitems")
public final class RssItemController extends BaseReadonlyRecordController<RssItem> {
	
	/**
     * 查询列表
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = { RequestMethod.GET })
    @ResponseBody
    public BasePageResponse<RssItem> getRecords(HttpServletRequest request, HttpServletResponse response) {
        return super._getRecords(request, response);
    }
    
    /**
     * 查询纪录 
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(method = { RequestMethod.GET }, value = "/{id}")
    @ResponseBody
    public BaseResponse<RssItem> getRecordByID(HttpServletRequest request, @PathVariable Integer id) {
        return super._getRecordByID(request, id);
    }

    /**
     * 添加纪录
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param record
     * @return
     */
    @PreAuthorize(role=ServerConstants.Roles.Admin)
    @RequestMapping(method = { RequestMethod.POST })
    @ResponseBody
    public BaseResponse<RssItem> addRecord(HttpServletRequest request, @RequestBody RssItem record){
        return super._addRecord(request, record);
    }

    /**
     * 更新纪录
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param record
     * @param id
     * @return
     */
    @PreAuthorize(role=ServerConstants.Roles.Admin)
    @RequestMapping(method = { RequestMethod.PUT }, value = "/{id}")
    @ResponseBody
    public BaseResponse<RssItem> updateRecord(HttpServletRequest request, @RequestBody RssItem record, @PathVariable Integer id) {
        record.setId(id);
        return super._updateRecord(request, record);
    }

    @PreAuthorize(role=ServerConstants.Roles.Admin)
    @RequestMapping(method = { RequestMethod.DELETE }, value = "/{id}")
    @ResponseBody
    public EmptyResponse deleteRecord(HttpServletRequest request, @PathVariable Integer id) {
        return super._deleteRecord(request, id);
    }
	
    @RequestMapping(method = { RequestMethod.GET }, consumes="application/xml")
    public ModelAndView getXml(HttpServletRequest request, HttpServletResponse response) {
    	
    	ModelAndView modelAndView = new ModelAndView("rssView");
    	
    	List<RssItem> rssItems = new ArrayList<RssItem>();

    	modelAndView.addObject("rssItemList", rssItems);
		
    	modelAndView.addObject("feedTitle","网易头条新闻");
    	modelAndView.addObject("feedDesc","头条新闻");
    	modelAndView.addObject("feedLink","http://news.163.com/");
		
		return modelAndView;
    }
    
    @RequestMapping(method = { RequestMethod.GET }, consumes="application/json")
    public String getJson(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("seolist", "haha,");
    	return "home/msnry";
    }
}
