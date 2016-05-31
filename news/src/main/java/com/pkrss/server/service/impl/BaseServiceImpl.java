package com.pkrss.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.pkrss.server.http.request.BasePageRequestUrlParams;
import com.pkrss.server.http.response.BasePageResponse;
import com.pkrss.server.service.BaseService;
import com.pkrss.server.utils.PageUtil;

import tk.mybatis.mapper.common.Mapper;


public abstract class BaseServiceImpl<MAP extends Mapper<T>,T> implements BaseService<T> {

    @Autowired
    protected MAP reocrdMap;
    
    @Override
    public T getById(Object id) {
        return reocrdMap.selectByPrimaryKey(id);
    }

    @Override
    public int addSelective(T record) {
        return reocrdMap.insertSelective(record);
    }

    @Override
    public int removeById(Object id) {
        return reocrdMap.deleteByPrimaryKey(id);
    }

    @Override
    public int modifyByIdSelective(T record) {
        return reocrdMap.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return reocrdMap.updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectAll(){
        return reocrdMap.selectAll();
    }
    
    @Override
    public List<T> selectAll(int offset, int limit){
        PageHelper.offsetPage(offset, limit);
        return reocrdMap.selectAll();
    }

    @Override
    public BasePageResponse.Data<T> selectAll(BasePageRequestUrlParams requestPageParams){
        return PageUtil.createPageResponse(requestPageParams, selectAll(requestPageParams.getOffset(), requestPageParams.getLimit()));
    }
    
}
