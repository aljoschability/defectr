package com.aljoschability.defectr.ui.viewers;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.mylyn.commons.ui.ControlListItem;
import org.eclipse.mylyn.commons.ui.GradientCanvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;

import com.aljoschability.defectr.Feed;
import com.aljoschability.defectr.FeedImage;
import com.aljoschability.defectr.ui.ImageManager;

public class ChannelListItem extends ControlListItem {
	private static final int ICON_GAP = 10;

	private GradientCanvas canvas;

	private ToolBar toolBar;
	private ToolBarManager toolBarManager;

	private Label titleLabel;

	private Label iconLabel;

	private Label descriptionLabel;

	public ChannelListItem(Composite parent, Object element) {
		super(parent, SWT.NONE, element);

		registerChild(titleLabel);
		registerChild(iconLabel);
		registerChild(descriptionLabel);
		registerChild(toolBar);
	}

	@Override
	public void dispose() {
		super.dispose();
		toolBarManager.dispose();
	}

	@Override
	protected void createContent() {
		setLayout(new FillLayout());

		canvas = new GradientCanvas(this, SWT.NONE);

		FormLayout layout = new FormLayout();
		layout.marginHeight = 3;
		layout.marginWidth = 3;
		canvas.setLayout(layout);

		iconLabel = new Label(canvas, SWT.NONE);
		FormData fd = new FormData();
		fd.left = new FormAttachment(0);
		iconLabel.setLayoutData(fd);

		titleLabel = new Label(canvas, SWT.NONE);
		titleLabel.setFont(JFaceResources.getBannerFont());
		fd = new FormData();
		fd.left = new FormAttachment(iconLabel, ICON_GAP);
		titleLabel.setLayoutData(fd);

		descriptionLabel = new Label(canvas, SWT.WRAP);

		toolBarManager = new ToolBarManager(SWT.FLAT);
		toolBar = toolBarManager.createControl(canvas);

		fd = new FormData();
		fd.top = new FormAttachment(titleLabel, 5);
		fd.left = new FormAttachment(iconLabel, 10);
		fd.right = new FormAttachment(toolBar, -5);
		descriptionLabel.setLayoutData(fd);

		fd = new FormData();
		fd.right = new FormAttachment(100);
		toolBar.setLayoutData(fd);

		// TODO: gradient
		// Color colorCategoryGradientStart = new Color(getDisplay(), new RGB(150, 150, 150));
		// Color colorCategoryGradientEnd = new Color(getDisplay(), new RGB(50, 50, 50));
		//
		// canvas.setSeparatorVisible(true);
		// canvas.setSeparatorAlignment(SWT.TOP);
		// canvas.setBackgroundGradient(new Color[] { colorCategoryGradientStart, colorCategoryGradientEnd },
		// new int[] { 100 }, true);
		// canvas.putColor(GradientCanvas.H_BOTTOM_KEYLINE1, colorCategoryGradientStart);
		// canvas.putColor(GradientCanvas.H_BOTTOM_KEYLINE2, colorCategoryGradientEnd);

		refresh();
	}

	@Override
	protected void refresh() {
		Feed data = (Feed) getData();
		Image image = getImage(data);
		if (image == null) {
			// left align with column
			((FormData) titleLabel.getLayoutData()).left = new FormAttachment(0);
			((FormData) descriptionLabel.getLayoutData()).left = new FormAttachment(0);
		} else {
			// leave space between icon and text
			((FormData) titleLabel.getLayoutData()).left = new FormAttachment(iconLabel, ICON_GAP);
			((FormData) descriptionLabel.getLayoutData()).left = new FormAttachment(iconLabel, ICON_GAP);
		}
		iconLabel.setImage(image);
		titleLabel.setText(data.getTitle());
		descriptionLabel.setText((data.getDescription() != null) ? data.getDescription() : ""); //$NON-NLS-1$

		toolBarManager.removeAll();
		// final String url = data.getUrl();
		// if (url != null) {
		// Action action = new Action() {
		// @Override
		// public void run() {
		// WorkbenchUtil.openUrl(url, IWorkbenchBrowserSupport.AS_EXTERNAL);
		// }
		// };
		// action.setImageDescriptor(CommonImages.INFORMATION);
		// toolBarManager.add(action);
		// }
		toolBarManager.update(false);
	}

	private Image getImage(Feed data) {
		FeedImage image = data.getImage();
		if (image != null) {
			return ImageManager.getImage(image.getUrl());
		}
		return null;
	}
}
