package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class FeedburnerParser extends AbstractParser {
	public static final String URI = "http://rssnamespace.org/feedburner/ext/1.0"; //$NON-NLS-1$

	private static final String INFO = "info"; //$NON-NLS-1$
	private static final String ORIG_LINK = "origLink"; //$NON-NLS-1$
	private static final String ORIG_ENCLOSURE_LINK = "origEnclosureLink"; //$NON-NLS-1$
	private static final String BROWSER_FRIENDLY = "browserFriendly"; //$NON-NLS-1$

	public FeedburnerParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case INFO:
			// TODO: implement handling of local part
			break;
		case ORIG_LINK:
			// TODO: implement handling of local part
			break;
		case ORIG_ENCLOSURE_LINK:
			// TODO: implement handling of local part
			break;
		case BROWSER_FRIENDLY:
			// TODO: implement handling of local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
