package com.aljoschability.defectr.ui;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;

public class PlayerPart {
	@PostConstruct
	public void createWidgets(Composite parent) {
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(parent);

		// buttons
		Composite composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(composite);
		createControls(composite);

		// play bar
		composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(composite);
		createPlaybar(composite);

		// volume bar
		composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(composite);
		createVolumebar(composite);
	}

	private void createControls(Composite parent) {
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(parent);

		Button previousButton = new Button(parent, SWT.PUSH);
		previousButton.setImage(CoreImages.get(CoreImages.CONTROL_PREVIOUS));
		previousButton.setToolTipText("Previous");
		previousButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("SELECTED PREVIOUS");
			}
		});

		final Button playButton = new Button(parent, SWT.PUSH);
		playButton.setImage(CoreImages.get(CoreImages.CONTROL_PLAY));
		playButton.setToolTipText("Play/Pause");
		playButton.addSelectionListener(new SelectionAdapter() {
			private boolean isPlaying = false;

			@Override
			public void widgetSelected(SelectionEvent e) {
				isPlaying = !isPlaying;
				if (isPlaying) {
					playButton.setImage(CoreImages.get(CoreImages.CONTROL_PLAY));
				} else {
					playButton.setImage(CoreImages.get(CoreImages.CONTROL_PAUSE));
				}

				System.out.println("SELECTED PLAY/PAUSE");
			}
		});

		Button nextButton = new Button(parent, SWT.PUSH);
		nextButton.setImage(CoreImages.get(CoreImages.CONTROL_NEXT));
		nextButton.setToolTipText("Next");
		nextButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("SELECTED NEXT");
			}
		});
	}

	private void createPlaybar(Composite parent) {
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(parent);

		Label currentTimeLabel = new Label(parent, SWT.FILL);
		GridDataFactory.fillDefaults().applyTo(currentTimeLabel);
		currentTimeLabel.setText("23:00"); // seconds = 23*60=1380

		final Scale progressScale = new Scale(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(progressScale);
		progressScale.setMinimum(0);
		progressScale.setMaximum(6000);
		progressScale.setPageIncrement(progressScale.getMaximum() / 25);
		progressScale.setIncrement(1);
		progressScale.setSelection(1380);
		progressScale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("PROGRESS SET TO: " + progressScale.getSelection());
			}
		});
		Label overallTimeLabel = new Label(parent, SWT.FILL);
		GridDataFactory.fillDefaults().applyTo(overallTimeLabel);
		overallTimeLabel.setText("100:00"); // seconds = 100*60=6000
	}

	private void createVolumebar(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);

		final Scale volumeScale = new Scale(parent, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(volumeScale);
		volumeScale.setMinimum(0);
		volumeScale.setMaximum(100);
		volumeScale.setPageIncrement(10);
		volumeScale.setIncrement(1);
		volumeScale.setSelection(75);
		volumeScale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("VOLUME SET TO: " + volumeScale.getSelection());
			}
		});
	}
}
