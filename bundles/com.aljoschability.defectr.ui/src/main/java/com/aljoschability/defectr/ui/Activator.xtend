package com.aljoschability.defectr.ui;

import com.aljoschability.core.ui.runtime.AbstractActivator;
import com.aljoschability.core.ui.runtime.IActivator;
import org.eclipse.jface.resource.ImageRegistry

final class Activator extends AbstractActivator {
	static IActivator INSTANCE

	def static IActivator get() {
		Activator::INSTANCE
	}

	override void initialize() {
		Activator::INSTANCE = this

		// add images
		addImage(CoreImages.CONTROL_NEXT);
		addImage(CoreImages.CONTROL_PAUSE);
		addImage(CoreImages.CONTROL_PLAY);
		addImage(CoreImages.CONTROL_PREVIOUS);
	}

	override void dispose() {
		Activator::INSTANCE = null
	}

	def static ImageRegistry getImageRegistry() {
		// TODO: make it visible on upstream
	}
}
