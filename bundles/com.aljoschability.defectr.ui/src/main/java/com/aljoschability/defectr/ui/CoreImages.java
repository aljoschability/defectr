package com.aljoschability.defectr.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class CoreImages {
	public static final String CONTROL_NEXT = "icons/player/next.png"; //$NON-NLS-1$
	public static final String CONTROL_PAUSE = "icons/player/pause.png"; //$NON-NLS-1$
	public static final String CONTROL_PLAY = "icons/player/play.png"; //$NON-NLS-1$
	public static final String CONTROL_PREVIOUS = "icons/player/previous.png"; //$NON-NLS-1$

	public static final Image get(String key) {
		return Activator.get().getImage(key);
	}

	public static final ImageDescriptor getDescriptor(String key) {
		return Activator.get().getImageDescriptor(key);
	}
}
