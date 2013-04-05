package com.aljoschability.defectr.feed.parsers;

import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;

public class CommentParser extends AbstractParser {
	public static final String URI = "http://wellformedweb.org/CommentAPI/"; //$NON-NLS-1$

	private static final String COMMENT_RSS = "commentRss"; //$NON-NLS-1$

	public CommentParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case COMMENT_RSS:
			// TODO: handle local part
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}
}
