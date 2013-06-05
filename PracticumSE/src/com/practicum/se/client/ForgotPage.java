package com.practicum.se.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ForgotPage extends Composite {
	private VerticalPanel vp1 = new VerticalPanel();
	LoginServiceAsync a1 = GWT.create(LoginService.class);
	ForgotServiceAsync f1 = GWT.create(ForgotService.class);
	ReturnServiceAsync r1 = GWT.create(ReturnService.class);
	MailServiceAsync m = GWT.create(MailService.class);

	public ForgotPage() {
		initWidget(this.vp1);
		vp1.setWidth("1300px");
		vp1.setHeight("200px");
		vp1.addStyleName("abp1");
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		final Label Loginlb1 = new Label("Enter your Email Id");
		final TextBox LoginEmail1 = new TextBox();
		final Button LoginButton1 = new Button("Submit");
		FlexTable fp = new FlexTable();
		fp.setWidget(1, 0, Loginlb1);
		fp.setWidget(1, 1, LoginEmail1);
		fp.setCellSpacing(20);
		

		LoginButton1.setText("Submit");
		fp.setWidget(2, 0, LoginButton1);
		
		LoginButton1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
				final String c1 = LoginEmail1.getText();// put email id in c1
				
				f1.check(c1, new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result.equals("yes")) {
							
							r1.pass(c1, new AsyncCallback<String>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									
									m.sendMail(c1, result,
											new AsyncCallback<String>() {

												@Override
												public void onFailure(
														Throwable caught) {
													// TODO Auto-generated
													
													System.out.println(caught);

												}

												@Override
												public void onSuccess(
														String result) {
													// TODO Auto-generated
													
													if (result.equals("true")) {
														System.out
																.println("hiiiiiiii testing in login screen");
														Window.alert("Password sent to your mail id");

													}
													if (result.equals("false")) {
														System.out
																.println("hiiiiiiii testing in login screen NNO");
														Window.alert("mail not ok");

													}

												}

											});

								}

							});

						} else {
							Window.alert("Wrong Entry");
						}

					}

					@Override
					public void onFailure(Throwable caught) {

						Window.alert("Result not ok");
					}
				});

			}

		});
		vp1.add(fp);
	}

}
