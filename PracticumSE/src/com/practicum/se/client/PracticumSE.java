package com.practicum.se.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PracticumSE implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel vn = new VerticalPanel();
		// vn.setBorderWidth(4);

		SecondPage sp = new SecondPage();
		// hp.add(sp);
		// hp.setBorderWidth(3);
		FirstPanel fp = new FirstPanel();
		vn.add(fp);
		HTML H = new HTML();
		H.setHeight("35px");
		vn.add(H);

		// vn.add(hp);
		vn.add(sp);
		RootPanel.get().add(vn);

	}
}
