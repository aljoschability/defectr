package com.aljoschability.defectr.feed.vogel;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String CHANNEL = "channel";
	static final String LANGUAGE = "language";
	static final String COPYRIGHT = "copyright";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";
	static final String PUB_DATE = "pubDate";
	static final String GUID = "guid";

	final URL url;

	public RSSFeedParser(String feedUrl) {
		try {
			this.url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
		String result = "";
		event = eventReader.nextEvent();
		if (event instanceof Characters) {
			result = event.asCharacters().getData();
		}
		return result;
	}

	private void handleEndDocument(XMLEvent event) {
		// TODO Auto-generated method stub
		System.out.println("end document");
	}

	private void handleEndElement(EndElement event) {
		// TODO Auto-generated method stub
		System.out.println("\tend element");
	}

	private void handleStartDocument(XMLEvent event) {

		// TODO Auto-generated method stub
		System.out.println("start document");
	}

	private void handleStartElement(StartElement event) {
		String uri = event.getName().getNamespaceURI();
		// TODO Auto-generated method stub
		System.out.println("\tstart element " + uri);
	}

	private InputStream read() {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Feed readFeed() {
		Feed feed = null;
		try {
			// create factory
			XMLInputFactory factory = XMLInputFactory.newInstance();

			// create input stream
			InputStream stream = read();

			// create reader
			XMLEventReader reader = factory.createXMLEventReader(stream);

			// iterate through file
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();

				if (event.isStartDocument()) {
					handleStartDocument(event);
				} else if (event.isStartElement()) {
					handleStartElement(event.asStartElement());
				} else if (event.isEndElement()) {
					handleEndElement(event.asEndElement());
				} else if (event.isEndDocument()) {
					handleEndDocument(event);
				}
			}

			boolean isFeedHeader = true;
			// Set header values intial to the empty string
			String description = "";
			String title = "";
			String link = "";
			String language = "";
			String copyright = "";
			String author = "";
			String pubdate = "";
			String guid = "";
			// Read the XML document
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				if (event.isStartElement()) {
					handleStartElement(event.asStartElement());

					// check it
					StartElement selement = event.asStartElement();
					System.out.println(selement.getName().getNamespaceURI());

					String localPart = event.asStartElement().getName().getLocalPart();
					switch (localPart) {
					case ITEM:
						if (isFeedHeader) {
							isFeedHeader = false;
							feed = new Feed(title, link, description, language, copyright, pubdate);
						}
						event = reader.nextEvent();
						break;
					case TITLE:
						title = getCharacterData(event, reader);
						break;
					case DESCRIPTION:
						description = getCharacterData(event, reader);
						break;
					case LINK:
						link = getCharacterData(event, reader);
						break;
					case GUID:
						guid = getCharacterData(event, reader);
						break;
					case LANGUAGE:
						language = getCharacterData(event, reader);
						break;
					case AUTHOR:
						author = getCharacterData(event, reader);
						break;
					case PUB_DATE:
						pubdate = getCharacterData(event, reader);
						break;
					case COPYRIGHT:
						copyright = getCharacterData(event, reader);
						break;
					}
				} else if (event.isEndElement()) {
					if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
						FeedMessage message = new FeedMessage();
						message.setAuthor(author);
						message.setDescription(description);
						message.setGuid(guid);
						message.setLink(link);
						message.setTitle(title);
						feed.getMessages().add(message);
						event = reader.nextEvent();
						continue;
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
		return feed;
	}
}