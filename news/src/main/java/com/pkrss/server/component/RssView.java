package com.pkrss.server.component;

import java.nio.channels.Channel;
import com.rometools.rome.feed.rss.Item;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.pkrss.server.domain.RssItem;

@Component("rssView")
public final class RssView extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String,Object> model, Channel feed,
			HttpServletRequest request) {
		
		String feedTitle = (String)model.get("feedTitle");
		String feedDesc = (String)model.get("feedDesc");
		String feedLink = (String)model.get("feedLink");
		
		feed.setTitle(feedTitle);
		feed.setDescription(feedDesc);
		feed.setLink(feedLink);
	}

	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		@SuppressWarnings("unchecked")
		List<RssItem> rssItems = (List<RssItem>) model.get("rssItemList");

		List<Item> feedItems = new ArrayList<Item>();
		for (RssItem rssItem : rssItems) {
			Item feedItem = new Item();
			feedItem.setTitle(rssItem.getTitle());
			feedItem.setAuthor(rssItem.getAuthor());
			feedItem.setPubDate(rssItem.getDatePublished());

			Description desc = new Description();
			desc.setType("text/html");
			desc.setValue(rssItem.getDescription());
			feedItem.setDescription(desc);

			feedItem.setLink(rssItem.getLink());
			feedItems.add(feedItem);
		}

		return feedItems;
	}

}
