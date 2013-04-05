package com.aljoschability.defectr.feed;

import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

public interface IParser {
	void handleEndElement(EndElement element);

	void handleStartElement(StartElement element);
}
