package com.aljoschability.defectr.ui;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

public class PlaylistsPart {
	private TreeViewer viewer;

	@PostConstruct
	public void createControls(Composite parent) {
		Tree tree = new Tree(parent, SWT.BORDER);

		viewer = new TreeViewer(tree);
	}

	@Focus
	public void onFocus() {
		viewer.getControl().setFocus();
	}
}
