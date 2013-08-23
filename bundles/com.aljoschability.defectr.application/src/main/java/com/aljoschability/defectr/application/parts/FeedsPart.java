package com.aljoschability.defectr.application.parts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.mylyn.commons.ui.ControlListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.aljoschability.defectr.DefectrFactory;
import com.aljoschability.defectr.Feed;
import com.aljoschability.defectr.FeedImage;
import com.aljoschability.defectr.ui.viewers.ChannelsViewer;

public class FeedsPart {
	private ControlListViewer viewer;

	private List<Feed> input;

	public FeedsPart() {
		input = new ArrayList<>();

		Feed feed1 = DefectrFactory.eINSTANCE.createFeed();
		feed1.setTitle("Not Safe For Work");
		feed1.setDescription("Die Internationale Unterhaltungsgala mit Tim Pritlove und Holger Klein");
		FeedImage image1 = DefectrFactory.eINSTANCE.createFeedImage();
		image1.setUrl("http://meta.metaebene.me/media/nsfw/not-safe-for-work-logo-64x64.jpg");
		feed1.setImage(image1);
		input.add(feed1);

		Feed feed2 = DefectrFactory.eINSTANCE.createFeed();
		feed2.setTitle("CRE: Technik, Kultur, Gesellschaft");
		feed2.setDescription("Der Interview-Podcast mit Tim Pritlove");
		FeedImage image2 = DefectrFactory.eINSTANCE.createFeedImage();
		image2.setUrl("http://meta.metaebene.me/media/cre/cre-logo-64x64.jpg");
		feed2.setImage(image2);

		input.add(feed2);

		Feed feed3 = DefectrFactory.eINSTANCE.createFeed();
		feed3.setTitle("Der Lautsprecher");
		feed3.setDescription("Ein Podcast über das Senden und Empfangen werden");
		FeedImage image3 = DefectrFactory.eINSTANCE.createFeedImage();
		image3.setUrl("http://meta.metaebene.me/media/lautsprecher/der-lautsprecher-logo-64x64.jpg");
		feed3.setImage(image3);
		input.add(feed3);
	}

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout());

		IContentProvider contentProvider = new ArrayContentProvider();

		viewer = new ChannelsViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
		viewer.setContentProvider(contentProvider);
		viewer.setInput(input);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
	}

	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
