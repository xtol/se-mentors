package com.practicum.se.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class PracticumSE implements EntryPoint {
	
	public void onModuleLoad() {
		VerticalPanel vn = new VerticalPanel();
		

		SecondPage sp = new SecondPage();
		
		FirstPanel fp = new FirstPanel();
		vn.add(fp);
		HTML H = new HTML();
		H.setHeight("35px");
		vn.add(H);

		
		vn.add(sp);
		RootPanel.get().add(vn);

	}
}
