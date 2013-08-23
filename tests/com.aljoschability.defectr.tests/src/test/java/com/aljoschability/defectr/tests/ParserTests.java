package com.aljoschability.defectr.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aljoschability.defectr.feed.FeedReader;
import com.aljoschability.defectr.util.DefectrResourceFactoryImpl;

public class ParserTests {
	@BeforeClass
	public static void start() {
		DebugStream.activate();
	}

	@AfterClass
	public static void stop() {
		DebugStream.deactivate();
	}

	@Test
	public void testXmlParser() {
		String uri = null;
		uri = "http://www.podcast411.com/feed.xml";
		uri = "http://feeds.feedburner.com/bedroomradio";
		uri = "http://www.eatfeed.com/eatfeed.xml";
		uri = "http://www.quickanddirtytips.com/xml/mathdude.xml";
		uri = "http://feeds.feedburner.com/AndroidPolicePodcast";
		uri = "http://feeds.soundcloud.com/users/13359686-lifehacker/tracks";

		uri = "http://feeds.feedburner.com/NotSafeForWorkPodcast";
		uri = "http://feeds.feedburner.com/cre-podcast";
		uri = "http://feeds.feedburner.com/DerLautsprecher";

		FeedReader parser = new FeedReader(uri);

		// Container container = DefectrFactory.eINSTANCE.createContainer();
		// Category category = DefectrFactory.eINSTANCE.createCategory();

		parser.parse();

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("defectr", new DefectrResourceFactoryImpl());

		// resourceSet.
		String path = "C:\\test.defectr";
		URI resourceUri = URI.createFileURI(path);
		Resource resource = resourceSet.createResource(resourceUri, null);

		resource.getContents().addAll(parser.getChannels());

		try {
			resource.save(Collections.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
