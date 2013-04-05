package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class ContentParser extends AbstractParser {
	public static final String URI = "http://purl.org/rss/1.0/modules/content/"; //$NON-NLS-1$

	private static final String ENCODED = "encoded"; //$NON-NLS-1$

	public ContentParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case ENCODED:
			// TODO: handle local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
