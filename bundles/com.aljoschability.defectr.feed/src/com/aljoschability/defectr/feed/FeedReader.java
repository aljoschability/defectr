package com.aljoschability.defectr.feed;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.aljoschability.defectr.Category;
import com.aljoschability.defectr.Episode;
import com.aljoschability.defectr.Feed;
import com.aljoschability.defectr.feed.parsers.AtomParser;
import com.aljoschability.defectr.feed.parsers.CommentParser;
import com.aljoschability.defectr.feed.parsers.ContentParser;
import com.aljoschability.defectr.feed.parsers.DublinCoreParser;
import com.aljoschability.defectr.feed.parsers.FeedburnerParser;
import com.aljoschability.defectr.feed.parsers.ItunesParser;
import com.aljoschability.defectr.feed.parsers.MediaParser;
import com.aljoschability.defectr.feed.parsers.OpenSearchParser;
import com.aljoschability.defectr.feed.parsers.RssParser;
import com.aljoschability.defectr.feed.parsers.SlashParser;
import com.aljoschability.defectr.feed.parsers.SyndicationParser;

public class FeedReader implements IFeedReader {
	private final URL url;

	private Category category;

	private XMLEventReader reader;

	private IParser NO_PARSER = new IParser() {
		@Override
		public void handleEndElement(EndElement element) {
			// TODO Auto-generated method stub
		}

		@Override
		public void handleStartElement(StartElement element) {
			// TODO Auto-generated method stub
		}
	};

	private Map<String, IParser> parsers;

	private Feed channel;

	private Episode item;

	private final List<Feed> channels;

	public FeedReader(String feedUrl) {
		channels = new ArrayList<>();

		parsers = new LinkedHashMap<>();

		parsers.put(RssParser.URI, new RssParser(this));
		parsers.put(AtomParser.URI, new AtomParser(this));
		parsers.put(FeedburnerParser.URI, new FeedburnerParser(this));
		parsers.put(ContentParser.URI, new ContentParser(this));
		parsers.put(CommentParser.URI, new CommentParser(this));
		parsers.put(SlashParser.URI, new SlashParser(this));
		parsers.put(SyndicationParser.URI, new SyndicationParser(this));
		parsers.put(ItunesParser.URI, new ItunesParser(this));
		parsers.put(DublinCoreParser.URI, new DublinCoreParser(this));
		parsers.put(MediaParser.URI, new MediaParser(this));
		parsers.put(OpenSearchParser.URI, new OpenSearchParser(this));

		try {
			this.url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void endChannel() {
		channel = null;
	}

	@Override
	public void endItem() {
		item = null;
	}

	@Override
	public Category getCategory(String value) {
		System.out.println("CATEGORY missing: '" + value + "'");
		return null;
	}

	@Override
	public Feed getChannel() {
		return channel;
	}

	public List<Feed> getChannels() {
		return channels;
	}

	@Override
	public String getElementText() {
		try {
			return reader.getElementText();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Episode getItem() {
		return item;
	}

	private IParser getParser(String key) {
		IParser parser = parsers.get(key);

		if (parser != null) {
			return parser;
		}
		// TODO: log
		System.out.println("could not find parser for " + key);
		return NO_PARSER;
	}

	private void handleEndElement(EndElement event) {
		getParser(event.getName().getNamespaceURI()).handleEndElement(event);
	}

	private void handleStartElement(StartElement event) {
		getParser(event.getName().getNamespaceURI()).handleStartElement(event);
	}

	public void parse() {
		try {
			// create factory
			XMLInputFactory factory = XMLInputFactory.newInstance();

			// create input stream
			InputStream stream = url.openStream();

			// create reader
			reader = factory.createXMLEventReader(stream);

			// iterate through file
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();

				if (event.isStartDocument()) {
					// TODO: handle start document
					// handleStartDocument((StartDocument) event);
				} else if (event.isEndDocument()) {
					// TODO: handle end document
					// handleEndDocument((EndDocument) event);
				} else if (event.isStartElement()) {
					handleStartElement((StartElement) event);
				} else if (event.isEndElement()) {
					handleEndElement((EndElement) event);
				}
			}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void startChannel(Feed channel) {
		this.channel = channel;
		channels.add(channel);
	}

	@Override
	public void startItem(Episode item) {
		this.item = item;
		getChannel().getEpisodes().add(item);
	}
}
