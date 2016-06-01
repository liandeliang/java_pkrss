package com.pkrss.server.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pkrss.server.constant.ServerConstants;
import com.pkrss.server.domain.RssLocale;
import com.pkrss.server.http.response.BasePageResponse;
import com.pkrss.server.http.response.BaseResponse;
import com.pkrss.server.http.response.EmptyResponse;
import com.pkrss.server.secure.PreAuthorize;

@Controller
@RequestMapping("/rsslocales")
public final class RssLocaleController extends BaseReadonlyRecordController<RssLocale> {
	
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
    public BasePageResponse<RssLocale> getRecords(HttpServletRequest request, HttpServletResponse response) {
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
    public BaseResponse<RssLocale> getRecordByID(HttpServletRequest request, @PathVariable Integer id) {
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
    public BaseResponse<RssLocale> addRecord(HttpServletRequest request, @RequestBody RssLocale record){
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
    public BaseResponse<RssLocale> updateRecord(HttpServletRequest request, @RequestBody RssLocale record, @PathVariable Integer id) {
        record.setId(id);
        return super._updateRecord(request, record);
    }

    @PreAuthorize(role=ServerConstants.Roles.Admin)
    @RequestMapping(method = { RequestMethod.DELETE }, value = "/{id}")
    @ResponseBody
    public EmptyResponse deleteRecord(HttpServletRequest request, @PathVariable Integer id) {
        return super._deleteRecord(request, id);
    }
}
