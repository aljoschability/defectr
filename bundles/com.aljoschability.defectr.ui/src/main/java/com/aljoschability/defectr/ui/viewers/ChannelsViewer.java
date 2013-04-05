package com.aljoschability.defectr.ui.viewers;

import org.eclipse.mylyn.commons.ui.ControlListItem;
import org.eclipse.mylyn.commons.ui.ControlListViewer;
import org.eclipse.swt.widgets.Composite;


public class ChannelsViewer extends ControlListViewer {
	public ChannelsViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected ControlListItem doCreateItem(Composite parent, Object element) {
		return new ChannelListItem(parent, element);
	}
}
