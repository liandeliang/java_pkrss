package com.pkrss.server.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pkrss.server.domain.RssItem;
import com.pkrss.server.mapper.RssItemMapper;
import com.pkrss.server.service.RssItemService;

@Service
public final class RssItemServiceImpl extends BaseServiceImpl<RssItemMapper,RssItem> implements RssItemService {

	@Override
	public List<RssItem> selectAll(int lid, int cid, int tid, int offset, int limit) {
		base
		return null;
	}
	
    
}
