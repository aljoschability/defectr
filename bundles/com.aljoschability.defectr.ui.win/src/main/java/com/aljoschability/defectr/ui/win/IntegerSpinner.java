package com.aljoschability.defectr.ui.win;

/*
 * Spinner example snippet: create and initialize a spinner widget
 * 
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 * 
 * @since 3.1
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class IntegerSpinner {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		Spinner spinner = new Spinner (shell, SWT.BORDER);
		spinner.setMinimum(0);
		spinner.setMaximum(1000);
		spinner.setSelection(500);
		spinner.setIncrement(1);
		spinner.setPageIncrement(100);
		Rectangle clientArea = shell.getClientArea();
		spinner.setLocation(clientArea.x, clientArea.y);
		spinner.pack();
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}