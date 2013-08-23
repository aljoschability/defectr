package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class SlashParser extends AbstractParser {
	public static final String URI = "http://purl.org/rss/1.0/modules/slash/"; //$NON-NLS-1$

	private static final String COMMENTS = "comments"; //$NON-NLS-1$

	public SlashParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case COMMENTS:
			// TODO: handle local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
