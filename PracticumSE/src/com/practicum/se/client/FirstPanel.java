package com.practicum.se.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FirstPanel extends Composite {
	private VerticalPanel vpanel = new VerticalPanel();

	public FirstPanel() {
		initWidget(this.vpanel);		
		vpanel.setStyleName("abp");
		Label lb = new Label("AUTHENTICATION");
		System.out.println("practicum");
		lb.setWidth("1300px");
		lb.setHeight("60px");
		lb.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lb.addStyleName("gwt-Label-head");
		HTML H = new HTML();
		H.setHeight("15px");
		vpanel.add(H);
		vpanel.add(lb);
	}
}
