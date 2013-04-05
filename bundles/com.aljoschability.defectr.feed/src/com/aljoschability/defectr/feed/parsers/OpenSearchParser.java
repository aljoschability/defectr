package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class OpenSearchParser extends AbstractParser {
	public static final String URI = "http://a9.com/-/spec/opensearch/1.1/"; //$NON-NLS-1$

	private static final String THUMBNAIL = "thumbnailXXXXXX"; //$NON-NLS-1$

	public OpenSearchParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case THUMBNAIL:
			// TODO: handle local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
