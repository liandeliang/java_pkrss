package com.pkrss.server.mapper;

import java.util.List;
import java.util.Map;

import com.pkrss.server.domain.RssItem;
import tk.mybatis.mapper.common.Mapper;

public interface RssItemMapper extends Mapper<RssItem> {
	List<RssItem> selectAllByParams(Map<String,Object> params);
}