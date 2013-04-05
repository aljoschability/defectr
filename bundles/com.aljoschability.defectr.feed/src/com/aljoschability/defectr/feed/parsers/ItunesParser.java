package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class ItunesParser extends AbstractParser {
	public static final String URI = "http://www.itunes.com/dtds/podcast-1.0.dtd"; //$NON-NLS-1$

	private static final String AUTHOR = "author"; //$NON-NLS-1$
	private static final String CATEGORY = "category"; //$NON-NLS-1$
	private static final String KEYWORDS = "keywords"; //$NON-NLS-1$
	private static final String OWNER = "owner"; //$NON-NLS-1$
	private static final String SUBTITLE = "subtitle"; //$NON-NLS-1$
	private static final String SUMMARY = "summary"; //$NON-NLS-1$
	private static final String BLOCK = "block"; //$NON-NLS-1$
	private static final String DURATION = "duration"; //$NON-NLS-1$
	private static final String EXPLICIT = "explicit"; //$NON-NLS-1$
	private static final String IMAGE = "image"; //$NON-NLS-1$
	private static final String EMAIL = "email"; //$NON-NLS-1$
	private static final String NAME = "name"; //$NON-NLS-1$

	public ItunesParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case SUBTITLE:
			// TODO: handle local part
			break;
		case SUMMARY:
			// TODO: handle local part
			break;
		case KEYWORDS:
			// TODO: handle local part
			break;
		case CATEGORY:
			// TODO: handle local part
			break;
		case AUTHOR:
			// TODO: handle local part
			break;
		case OWNER:
			// TODO: handle local part
			break;
		case BLOCK:
			// TODO: handle local part
			break;
		case DURATION:
			// TODO: handle local part
			break;
		case EXPLICIT:
			// TODO: handle local part
			break;
		case IMAGE:
			// TODO: handle local part
			break;
		case NAME:
			// TODO: handle local part
			break;
		case EMAIL:
			// TODO: handle local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
