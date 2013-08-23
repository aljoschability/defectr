package com.aljoschability.defectr.feed.parsers;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

import com.aljoschability.defectr.DefectrFactory;
import com.aljoschability.defectr.Episode;
import com.aljoschability.defectr.Feed;
import com.aljoschability.defectr.FeedImage;
import com.aljoschability.defectr.Link;
import com.aljoschability.defectr.MediaLink;
import com.aljoschability.defectr.feed.IFeedReader;

public class RssParser extends AbstractParser {
	public static final String URI = XMLConstants.NULL_NS_URI;

	private static final String RSS = "rss"; //$NON-NLS-1$
	private static final String CHANNEL = "channel"; //$NON-NLS-1$
	private static final String TITLE = "title"; //$NON-NLS-1$
	private static final String LINK = "link"; //$NON-NLS-1$
	private static final String DESCRIPTION = "description"; //$NON-NLS-1$
	private static final String LAST_BUILD_DATE = "lastBuildDate"; //$NON-NLS-1$
	private static final String LANGUAGE = "language"; //$NON-NLS-1$
	private static final String GENERATOR = "generator"; //$NON-NLS-1$
	private static final String COPYRIGHT = "copyright"; //$NON-NLS-1$
	private static final String MANAGING_EDITOR = "managingEditor"; //$NON-NLS-1$
	private static final String WEB_MASTER = "webMaster"; //$NON-NLS-1$
	private static final String TTL = "ttl"; //$NON-NLS-1$
	private static final String IMAGE = "image"; //$NON-NLS-1$
	private static final String URL = "url"; //$NON-NLS-1$
	private static final String WIDTH = "width"; //$NON-NLS-1$
	private static final String HEIGHT = "height"; //$NON-NLS-1$
	private static final String ITEM = "item"; //$NON-NLS-1$
	private static final String COMMENTS = "comments"; //$NON-NLS-1$
	private static final String PUB_DATE = "pubDate"; //$NON-NLS-1$
	private static final String CATEGORY = "category"; //$NON-NLS-1$
	private static final String GUID = "guid"; //$NON-NLS-1$
	private static final String ENCLOSURE = "enclosure"; //$NON-NLS-1$
	private static final String DOCS = "docs"; //$NON-NLS-1$
	private static final String AUTHOR = "author"; //$NON-NLS-1$

	private FeedImage image;

	private static final String LENGTH = "length"; //$NON-NLS-1$

	private static final String TYPE = "type"; //$NON-NLS-1$

	public RssParser(IFeedReader reader) {
		super(reader);
	}

	@Override
	public void handleEndElement(EndElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case CHANNEL:
			getReader().endChannel();
			break;
		case ITEM:
			getReader().endItem();
			break;
		case IMAGE:
			image = null;
			break;
		default:
			break;
		}
	}

	@Override
	public void handleStartElement(StartElement element) {
		String local = element.getName().getLocalPart();

		switch (local) {
		case RSS:
			// TODO: implement handling of local part
			break;
		case CHANNEL:
			parseChannelStart();
			break;
		case ITEM:
			parseItemStart();
			break;
		case TITLE:
			parseTitle();
			break;
		case LINK:
			parseLink();
			break;
		case DESCRIPTION:
			parseDescription();
			break;
		case IMAGE:
			parseImage();
			break;
		case URL:
			parseUrl();
			break;
		case WIDTH:
			parseWidth();
			break;
		case HEIGHT:
			parseHeight();
			break;
		case LAST_BUILD_DATE:
			parseLastBuildDate();
			break;
		case LANGUAGE:
			parseLanguage();
			break;
		case GENERATOR:
			parseGenerator();
			break;
		case COPYRIGHT:
			parseCopyright();
			break;
		case MANAGING_EDITOR:
			parseManagingEditor();
			break;
		case WEB_MASTER:
			parseWebMaster();
			break;
		case TTL:
			parseTimeToLive();
			break;
		case COMMENTS:
			parseComments();
			break;
		case PUB_DATE:
			parsePubDate();
			break;
		case CATEGORY:
			parseCategory();
			break;
		case GUID:
			parseGuid();
			break;
		case ENCLOSURE:
			parseEnclosure(element);
			break;
		case DOCS:
			// TODO: implement handling of local part
			System.out.println("IGNORED " + URI + " --> " + local);
			break;
		case AUTHOR:
			// TODO: implement handling of local part
			System.out.println("IGNORED " + URI + " --> " + local);
			break;
		default:
			System.out.println("unknown local part: '" + URI + "::" + local + "'");
			break;
		}
	}

	private void parseCategory() {
		System.out.println("ignored category parsing");

		return;
		// item
		// Episode item = getReader().getItem();
		// if (item != null) {
		// String value = getReader().getElementText();
		// Category category = getReader().getCategory(value);
		// if (!item.getCategories().contains(category)) {
		// item.getCategories().add(category);
		// }
		// }
	}

	private void parseChannelStart() {
		getReader().startChannel(DefectrFactory.eINSTANCE.createFeed());
	}

	private void parseComments() {
		// item
		Episode item = getReader().getItem();
		if (item != null) {
			Link link = DefectrFactory.eINSTANCE.createLink();
			link.setUrl(getReader().getElementText());
			item.setCommentLink(link);
		}
	}

	private void parseCopyright() {
		// channel
		Feed channel = getReader().getChannel();
		if (channel != null) {
			channel.setCopyright(getReader().getElementText());
			return;
		}
	}

	private void parseDescription() {
		Episode item = getReader().getItem();
		if (item != null) {
			item.setDescription(getReader().getElementText());
		} else {
			Feed channel = getReader().getChannel();
			channel.setDescription(getReader().getElementText());
		}
	}

	private void parseEnclosure(StartElement element) {
		// item
		Episode item = getReader().getItem();
		if (item != null) {
			String type = element.getAttributeByName(new QName(TYPE)).getValue();
			int length = Integer.parseInt(element.getAttributeByName(new QName(LENGTH)).getValue());
			String url = element.getAttributeByName(new QName(URL)).getValue();

			MediaLink enclosure = DefectrFactory.eINSTANCE.createMediaLink();
			enclosure.setType(type);
			enclosure.setLength(length);
			enclosure.setUrl(url);
			item.setEnclosure(enclosure);
		}
	}

	private void parseGenerator() {
		// channel
		Feed channel = getReader().getChannel();
		if (channel != null) {
			channel.setGenerator(getReader().getElementText());
			return;
		}
	}

	private void parseGuid() {
		// item
		Episode item = getReader().getItem();
		if (item != null) {
			item.setGuid(getReader().getElementText());
		}
	}

	private void parseHeight() {
		if (image != null) {
			try {
				image.setHeight(Integer.parseInt(getReader().getElementText()));
			} catch (NumberFormatException e) {
				System.out.println("could not parse width");
				e.printStackTrace();
			}
		}
	}

	private void parseImage() {
		if (getReader().getChannel().getImage() != null) {
			System.out.println("image already set!");
		}
		image = DefectrFactory.eINSTANCE.createFeedImage();
		getReader().getChannel().setImage(image);
	}

	private void parseItemStart() {
		getReader().startItem(DefectrFactory.eINSTANCE.createEpisode());
	}

	private void parseLanguage() {
		Feed channel = getReader().getChannel();
		if (channel != null) {
			channel.setLanguage(getReader().getElementText());
		}
	}

	private void parseLastBuildDate() {
		Feed channel = getReader().getChannel();
		if (channel != null) {
			channel.setLastBuildDate(parseDate(getReader().getElementText()));
		}
	}

	private void parseLink() {
		// image
		if (image != null) {
			image.setLink(getReader().getElementText());
			return;
		}

		// item
		Episode item = getReader().getItem();
		if (item != null) {
			Link link = DefectrFactory.eINSTANCE.createLink();
			link.setUrl(getReader().getElementText());
			item.setLink(link);
			return;
		}

		// channel
		Feed channel = getReader().getChannel();
		if (channel != null) {
			Link link = DefectrFactory.eINSTANCE.createLink();
			link.setUrl(getReader().getElementText());
			channel.setLink(link);
		}
	}

	private void parseManagingEditor() {
		// channel
		Feed channel = getReader().getChannel();
		if (channel != null) {
			System.out.println("AUTHOR problem: managing editor");
			// channel.setManagingEditor(getReader().getElementText());
			return;
		}
	}

	private void parsePubDate() {
		// item
		Episode item = getReader().getItem();
		if (item != null) {
			item.setPubDate(parseDate(getReader().getElementText()));
		}
	}

	private void parseTimeToLive() {
		// channel
		Feed channel = getReader().getChannel();
		if (channel != null) {
			try {
				channel.setUpdateInterval(Integer.parseInt(getReader().getElementText()));
				return;
			} catch (NumberFormatException e) {
				// TODO: log/catch
				e.printStackTrace();
			}
		}
	}

	private void parseTitle() {
		Feed channel;
		Episode item;
		channel = getReader().getChannel();
		item = getReader().getItem();
		if (image != null) {
			image.setTitle(getReader().getElementText());
		} else if (item != null) {
			item.setTitle(getReader().getElementText());
		} else if (channel != null) {
			channel.setTitle(getReader().getElementText());
		}
	}

	private void parseUrl() {
		if (image != null) {
			image.setUrl(getReader().getElementText());
		}
	}

	private void parseWebMaster() {
		// channel
		Feed channel = getReader().getChannel();
		if (channel != null) {
			System.out.println("AUTHOR problem: web author");
			// channel.setWebmaster(getReader().getElementText());
			return;
		}
	}

	private void parseWidth() {
		if (image != null) {
			try {
				image.setWidth(Integer.parseInt(getReader().getElementText()));
			} catch (NumberFormatException e) {
				System.out.println("could not parse width");
				e.printStackTrace();
			}
		}
	}
}
