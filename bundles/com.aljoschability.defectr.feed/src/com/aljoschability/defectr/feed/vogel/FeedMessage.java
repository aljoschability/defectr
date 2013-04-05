package com.aljoschability.defectr.feed.vogel;

/*
 * Represents one RSS message
 */
public class FeedMessage {

	String title;
	String description;
	String link;
	String author;
	String guid;

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public String getGuid() {
		return guid;
	}

	public String getLink() {
		return link;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", description=" + description + ", link=" + link + ", author=" + author
				+ ", guid=" + guid + "]";
	}

}