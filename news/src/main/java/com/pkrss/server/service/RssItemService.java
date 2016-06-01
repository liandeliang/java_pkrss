package com.pkrss.server.service;

import java.util.List;

import com.pkrss.server.domain.RssItem;

public interface RssItemService extends BaseService<RssItem> {
	List<RssItem> selectAll(int lid,int cid,int tid,int offset, int limit);
}
