package com.pkrss.server.service;

import com.pkrss.server.domain.RssLocale;

public interface RssLocaleService extends BaseService<RssLocale> {
	void refreshAll();
}
