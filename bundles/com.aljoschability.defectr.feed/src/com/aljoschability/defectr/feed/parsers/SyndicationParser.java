package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class SyndicationParser extends AbstractParser {
	public static final String URI = "http://purl.org/rss/1.0/modules/syndication/"; //$NON-NLS-1$

	private static final String UPDATE_PERIOD = "updatePeriod"; //$NON-NLS-1$
	private static final String UPDATE_FREQUENCY = "updateFrequency"; //$NON-NLS-1$

	public SyndicationParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case UPDATE_PERIOD:
			// TODO: handle local part
			String updatePeriod; // 'hourly' | 'daily' | 'weekly' | 'monthly' | 'yearly'
			break;
		case UPDATE_FREQUENCY:
			// TODO: handle local part
			int updateFrequency; // positive
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
