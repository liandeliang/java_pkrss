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
import com.pkrss.server.domain.RssCatalog;
import com.pkrss.server.http.response.BasePageResponse;
import com.pkrss.server.http.response.BaseResponse;
import com.pkrss.server.http.response.EmptyResponse;
import com.pkrss.server.secure.PreAuthorize;

@Controller
@RequestMapping("/rsscatalogs")
public final class RssCatalogController extends BaseReadonlyRecordController<RssCatalog> {
	
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
    public BasePageResponse<RssCatalog> getRecords(HttpServletRequest request, HttpServletResponse response) {
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
    public BaseResponse<RssCatalog> getRecordByID(HttpServletRequest request, @PathVariable Integer id) {
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
    public BaseResponse<RssCatalog> addRecord(HttpServletRequest request, @RequestBody RssCatalog record){
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
    public BaseResponse<RssCatalog> updateRecord(HttpServletRequest request, @RequestBody RssCatalog record, @PathVariable Integer id) {
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
