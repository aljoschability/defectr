package com.aljoschability.defectr.feed.parsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.feed.IFeedReader;
import com.aljoschability.defectr.feed.IParser;

public abstract class AbstractParser implements IParser {
	protected static Date parseDate(String value) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
			return df.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private final IFeedReader reader;

	public AbstractParser(IFeedReader reader) {
		this.reader = reader;
	}

	@Deprecated
	protected void debug(StartElement element) {
		QName name = element.getName();
		System.out.println("DEBUG: " + name.getNamespaceURI() + " --> " + name.getLocalPart());
		Iterator<?> attributes = element.getAttributes();
		while (attributes.hasNext()) {
			Attribute attribute = (Attribute) attributes.next();
			System.out.println("DEBUG: " + attribute.getName() + "=" + attribute.getValue());
		}
		System.out.println("DEBUG: " + getReader().getElementText());
	}

	protected IFeedReader getReader() {
		return reader;
	}

	@Override
	public void handleEndElement(EndElement element) {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleStartElement(StartElement element) {
		// TODO Auto-generated method stub
	}
}
