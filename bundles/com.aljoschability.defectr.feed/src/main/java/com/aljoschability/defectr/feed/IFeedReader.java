package com.aljoschability.defectr.feed;

import com.aljoschability.defectr.Category;
import com.aljoschability.defectr.Episode;
import com.aljoschability.defectr.Feed;

public interface IFeedReader {
	void endChannel();

	void endItem();

	Category getCategory(String value);

	Feed getChannel();

	String getElementText();

	Episode getItem();

	void startChannel(Feed feed);

	void startItem(Episode episode);
}
