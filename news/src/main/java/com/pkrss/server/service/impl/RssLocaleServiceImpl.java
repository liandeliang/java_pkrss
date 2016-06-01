package com.pkrss.server.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pkrss.server.domain.RssLocale;
import com.pkrss.server.helper.RssLocaleHelper;
import com.pkrss.server.mapper.RssLocaleMapper;
import com.pkrss.server.service.RssLocaleService;

@Service
public final class RssLocaleServiceImpl extends BaseServiceImpl<RssLocaleMapper,RssLocale> implements RssLocaleService {
	
    @Override
    public RssLocale getById(Object id) {
    	return RssLocaleHelper.getInstance().getById(id);
    }

    @Override
    public int addSelective(RssLocale record) {
    	int ret = reocrdMap.insertSelective(record);
    	refreshAll();
        return ret;
    }

    @Override
    public int removeById(Object id) {
    	int ret = reocrdMap.deleteByPrimaryKey(id);
    	refreshAll();
        return ret;
    }

    @Override
    public int modifyByIdSelective(RssLocale record) {
    	int ret = reocrdMap.updateByPrimaryKeySelective(record);
    	refreshAll();
        return ret;
    }

    @Override
    public int updateByPrimaryKey(RssLocale record) {
        int ret = reocrdMap.updateByPrimaryKey(record);
        refreshAll();
        return ret;
    }
    
    @Override
    public void refreshAll(){
    	List<RssLocale> list;
    	
    	list = reocrdMap.selectAll();
		RssLocaleHelper.getInstance().setRssLocales(list);
    }

    @Override
    public List<RssLocale> selectAll(){
    	List<RssLocale> list;

    	list = RssLocaleHelper.getInstance().getRssLocales();
    	
    	if(list == null){
    		list = reocrdMap.selectAll();
    		RssLocaleHelper.getInstance().setRssLocales(list);
    	}
    	
        return list;
    }
    
    @Override
    public List<RssLocale> selectAll(int offset, int limit){

    	List<RssLocale> rssLocales = selectAll();
    	if(rssLocales == null)
    		return null;
    	
    	return rssLocales.subList(offset, offset+limit);
    }
    
}
