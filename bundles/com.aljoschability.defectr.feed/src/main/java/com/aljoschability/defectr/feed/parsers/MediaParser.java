package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class MediaParser extends AbstractParser {
	public static final String URI = "http://search.yahoo.com/mrss/"; //$NON-NLS-1$

	private static final String THUMBNAIL = "thumbnail"; //$NON-NLS-1$
	private static final String CONTENT = "content"; //$NON-NLS-1$
	private static final String CREDIT = "credit"; //$NON-NLS-1$
	private static final String RATING = "rating"; //$NON-NLS-1$
	private static final String DESCRIPTION = "description"; //$NON-NLS-1$
	private static final String COPYRIGHT = "copyright"; //$NON-NLS-1$
	private static final String KEYWORDS = "keywords"; //$NON-NLS-1$
	private static final String CATEGORY = "category"; //$NON-NLS-1$

	public MediaParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case THUMBNAIL:
			// TODO: handle local part
			break;
		case CONTENT:
			// TODO: handle local part
			break;
		case CREDIT:
			// TODO: handle local part
			break;
		case RATING:
			// TODO: handle local part
			break;
		case DESCRIPTION:
			// TODO: handle local part
			break;
		case COPYRIGHT:
			// TODO: handle local part
			break;
		case KEYWORDS:
			// TODO: handle local part
			break;
		case CATEGORY:
			// TODO: handle local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
