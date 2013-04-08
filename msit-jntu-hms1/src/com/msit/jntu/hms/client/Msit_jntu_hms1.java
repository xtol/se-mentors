package com.msit.jntu.hms.client;

import com.msit.jntu.hms.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Msit_jntu_hms1 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	GreetingServiceRegistrationAsync a2 = GWT
			.create(GreetingServiceRegistration.class);

	public void onModuleLoad() {
		// TODO Auto-generated method stub
		// login
		final Label Loginlb = new Label("Email");
		final Label Pwdlb = new Label("Password");
		final TextBox LoginEmail = new TextBox();
		final PasswordTextBox LoginPwd = new PasswordTextBox();
		final Button LoginButton = new Button("LogIn");
		RootPanel.get("LoginEmail").add(LoginEmail);
		RootPanel.get("LoginPwd").add(LoginPwd);
		RootPanel.get("LoginButton").add(LoginButton);
		RootPanel.get("Loginlb").add(Loginlb);
		RootPanel.get("Pwdlb").add(Pwdlb);
		// login ended

		// registration
		final Label Fnamelb = new Label("First Name");
		final Label Mnamelb = new Label("Middle Name");
		final Label Lnamelb = new Label("Last Name");
		final Label EnterEmaillb = new Label("Enter Your Email");
		final Label ReenterEmaillb = new Label("Re-enter Email");
		final Button SignUpButton = new Button("SIGNUP");
		final Label errorLabel = new Label();

		final TextBox FnameTextBox = new TextBox();
		final TextBox MnameTextBox = new TextBox();
		final TextBox LnameTextBox = new TextBox();
		final TextBox EnterEmailTextBox = new TextBox();
		final TextBox ReenterEmailTextBox = new TextBox();

		RootPanel.get("errorLabel").add(errorLabel);
		RootPanel.get("Fnamelb").add(Fnamelb);
		RootPanel.get("Mnamelb").add(Mnamelb);
		RootPanel.get("Lnamelb").add(Lnamelb);
		RootPanel.get("EnterEmaillb").add(EnterEmaillb);
		RootPanel.get("ReenterEmaillb").add(ReenterEmaillb);
		RootPanel.get("FnameTextBox").add(FnameTextBox);
		RootPanel.get("MnameTextBox").add(MnameTextBox);
		RootPanel.get("LnameTextBox").add(LnameTextBox);
		RootPanel.get("EnterEmailTextBox").add(EnterEmailTextBox);
		RootPanel.get("ReenterEmailTextBox").add(ReenterEmailTextBox);
		RootPanel.get("SignUpButton").add(SignUpButton);

		// registration ended

		LoginButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String s1 = LoginEmail.getText();
				String s2 = LoginPwd.getText();

				a1.check(s1, s2, new AsyncCallback<String>() {

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result.equals("yes")) {
							Window.alert("Result ok");
						} else {
							Window.alert("Result not ok");
						}

					}

					@Override
					public void onFailure(Throwable caught) {

						Window.alert("Result not ok");
					}
				});
			}
		});

		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			private void sendNameToServer() {
				// TODO Auto-generated method stub
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = FnameTextBox.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

			}

		}

		SignUpButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final String s1 = FnameTextBox.getText();
				final String s2 = MnameTextBox.getText();
				final String s3 = LnameTextBox.getText();
				final String s4 = EnterEmailTextBox.getText();
				final String s5 = ReenterEmailTextBox.getText();
				a2.newuser(s1, s2, s3, s4, s5,
						new AsyncCallback<String>() {

							@Override
							public void onSuccess(String result) {
								// TODO Auto-generated method stub
								if (result.equals("yes")) {
									Window.alert("New User Added");
								}
							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								caught.printStackTrace();
								Window.alert("No user aadded");
							}
						});

//				a2.check(s1, s2, s3, s4, s5, new AsyncCallback<String>() {
//
//					@Override
//					public void onSuccess(String result) {
//						// TODO Auto-generated method stub
//
//						if (result.equals("yes")) {
//							Window.alert("Result not ok");
//						}
//
//					}
//
//					@Override
//					public void onFailure(Throwable caught) {
//						a2.newuser(s1, s2, s3, s4, s5,
//								new AsyncCallback<String>() {
//
//									@Override
//									public void onSuccess(String result) {
//										// TODO Auto-generated method stub
//										if (result.equals("yes")) {
//											Window.alert("New User Added");
//										}
//									}
//
//									@Override
//									public void onFailure(Throwable caught) {
//										// TODO Auto-generated method stub
//										Window.alert("No user aadded");
//									}
//								});
//						//Window.alert("Result not ok");
//					}
//				});
			}
		});

		//
		// MyHandler handler = new MyHandler();
		// SignUpButton.addClickHandler(handler);
	}
}
