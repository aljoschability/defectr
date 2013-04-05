package com.aljoschability.defectr.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class ImageManager {
	public static Image getImage(String uri) {
		ImageRegistry registry = null;// TODO:Activator.get().getImageRegistry();

		Image image = registry.get(uri);
		if (image == null) {
			URL url;
			try {
				url = new URL(uri);

				ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
				if (descriptor != null) {
					ImageData scaledTo = descriptor.getImageData().scaledTo(64, 64);
					descriptor = ImageDescriptor.createFromImageData(scaledTo);
					registry.put(uri, descriptor);

					image = registry.get(uri);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return image;
	}
}
