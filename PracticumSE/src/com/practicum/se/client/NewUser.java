package com.practicum.se.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewUser extends Composite {

	private VerticalPanel vp1 = new VerticalPanel();
	LoginServiceAsync a1 = GWT.create(LoginService.class);
	RegistrationServiceAsync a2 = GWT.create(RegistrationService.class);
	private final SignupServiceAsync signupService = GWT
			.create(SignupService.class);
	boolean check = false;
	boolean check1 = false;

	@SuppressWarnings("deprecation")
	public NewUser(final String email) {
		VerticalPanel vp = new VerticalPanel();
		initWidget(this.vp1);
		vp.setWidth("1300px");
		vp.setHeight("700px");
		vp.addStyleName("abp1");
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label NUEnterCode = new Label(
				"Enter the code which is sent to your 'Email-ID' ");
		Label NUusername = new Label(
				"Username (How you want others to recognise you)");
		Label NUgender = new Label("Gender");
		Label NUpincode = new Label("Enter Pincode");
		Label NUaddress = new Label("Enter Address");
		Label NUphone = new Label("Enter Phone Nmber");
		Label NUdob = new Label("Date Of Birth");
		Label NUPassword = new Label("Enter Password");
		Label NUConfirmPassword = new Label("Confirm Password");
		final TextBox NUEnterCodetb = new TextBox();
		MultiWordSuggestOracle uname = new MultiWordSuggestOracle();
		for (int i = 0; i < UsernameGen.strings.size(); i++) {
			uname.add(UsernameGen.strings.get(i));
		}

		final SuggestBox NUusernametb = new SuggestBox(uname);
		final RadioButton NUgenderftb = new RadioButton("NUgender", "female");
		final RadioButton NUgendermtb = new RadioButton("NUgender", "male");
		final TextBox NUpincodetb = new TextBox();
		final TextBox NUphonetb = new TextBox();
		final PasswordTextBox NUPasswordtb = new PasswordTextBox();
		final PasswordTextBox NUConfirmPasswordtb = new PasswordTextBox();
		final Button NUbutton = new Button("New button");
		NUbutton.setText("Add Me");
		NUbutton.setEnabled(false);
		FlexTable fp1 = new FlexTable();
		fp1.setCellSpacing(10);
		fp1.setCellPadding(5);

		fp1.setWidget(0, 0, NUEnterCode);
		fp1.setWidget(0, 1, NUEnterCodetb);

		fp1.setWidget(1, 0, NUusername);
		fp1.setWidget(1, 1, NUusernametb);

		fp1.setWidget(2, 0, NUgender);
		HorizontalPanel hp1 = new HorizontalPanel();
		hp1.add(NUgenderftb);
		hp1.add(NUgendermtb);

		fp1.setWidget(2, 1, hp1);

		HandleEvents1 events1 = new HandleEvents1();

		fp1.setWidget(3, 0, events1);

		fp1.setWidget(4, 0, NUpincode);
		fp1.setWidget(4, 1, NUpincodetb);

		final TextArea NUaddresstb = new TextArea();
		NUaddresstb.addStyleName("demo-TextArea");
		NUaddresstb.setWidth("200px");

		fp1.setWidget(5, 0, NUaddress);
		fp1.setWidget(5, 1, NUaddresstb);

		fp1.setWidget(6, 0, NUphone);
		fp1.setWidget(6, 1, NUphonetb);

		fp1.setWidget(7, 0, NUdob);
		final ListBox NUyytb = new ListBox();
		String y = DateTimeFormat.getFormat("yyyy").format(new Date());
		int year = Integer.parseInt(y);
		NUyytb.addItem("YYYY");
		for (int i = (year - 18); i >= (year - 60); i--) {
			String s = "" + i;
			NUyytb.addItem(s);
		}
		final ListBox NUmmbtb = new ListBox();
		NUmmbtb.addItem("mmm");
		NUmmbtb.addItem("JAN");
		NUmmbtb.addItem("FEB");
		NUmmbtb.addItem("MAR");
		NUmmbtb.addItem("APR");
		NUmmbtb.addItem("MAY");
		NUmmbtb.addItem("JUN");
		NUmmbtb.addItem("JUL");
		NUmmbtb.addItem("AUG");
		NUmmbtb.addItem("SEP");
		NUmmbtb.addItem("OCT");
		NUmmbtb.addItem("NOV");
		NUmmbtb.addItem("DEC");		
		final ListBox NUddtb = new ListBox();
		NUddtb.addItem("dd");
		for (int i = 1; i <= 9; i++) {
			String d = "0" + i;
			NUddtb.addItem(d);
		}
		for (int i = 10; i <= 31; i++) {
			String d = "" + i;
			NUddtb.addItem(d);
		}

		HorizontalPanel hp = new HorizontalPanel();
		hp.add(NUddtb);
		hp.add(NUmmbtb);
		hp.add(NUyytb);
		fp1.setWidget(7, 1, hp);

		fp1.setWidget(8, 0, NUPassword);
		fp1.setWidget(8, 1, NUPasswordtb);

		fp1.setWidget(9, 0, NUConfirmPassword);
		fp1.setWidget(9, 1, NUConfirmPasswordtb);

		CheckBox cb = new CheckBox("I Agree to Conditions");
		cb.setChecked(false);

		// Hook up a handler to find out when it's clicked.
		cb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					NUbutton.setEnabled(true);
				} else {
					NUbutton.setEnabled(false);
				}
			}
		});

		Label NUcaptcha = new Label("Enter following code here");
		final TextBox captchaField = new TextBox();
		captchaField.setText("");
		final Label responseLabel = new Label();
		final Image captchaImage = new Image("/SimpleCaptcha.jpg");

		fp1.setWidget(10, 0, NUcaptcha);
		fp1.setWidget(10, 1, captchaField);

		fp1.setWidget(11, 1, captchaImage);

		fp1.setWidget(11, 2, responseLabel);

		fp1.setWidget(12, 0, cb);
		fp1.setWidget(12, 1, NUbutton);

		NUbutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			
				final String s0 = NUEnterCodetb.getText();
				final String s1 = NUusernametb.getText();
				final String s2 = (NUgenderftb.getValue()) ? NUgenderftb
						.getText() : NUgendermtb.getText();
				int index_cc = HandleEvents1.stateList.getSelectedIndex();
				final String s3 = HandleEvents1.stateList.getValue(index_cc);
				int index_ss = HandleEvents1.cityList.getSelectedIndex();
				final String s4 = HandleEvents1.cityList.getValue(index_ss);
				final String s5 = NUpincodetb.getText();
				final String s6 = NUaddresstb.getText();
				final String s7 = NUphonetb.getText();
				int index_dd = NUddtb.getSelectedIndex();
				final String s8 = NUddtb.getValue(index_dd);

				int index_mm = NUmmbtb.getSelectedIndex();
				final String s9 = NUmmbtb.getValue(index_mm);
				int index_yy = NUyytb.getSelectedIndex();
				final String s10 = NUyytb.getValue(index_yy);
				final String s11 = NUPasswordtb.getText();

				a2.check(email, s0, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result.equals("yes")) {

							check = true;
						} else {

							Window.alert("Wrong code check your email once");
							check = false;

							NUEnterCodetb.setFocus(true);
						}

					}

				});

				String captcha = captchaField.getText();
				
				signupService.performSignup(captcha,
						new AsyncCallback<Boolean>() {

							public void onSuccess(Boolean result) {
								if (result) {
									
									check1 = true;
									
								} else {
									Window.alert("CAPTCHA was invalid");
									check1 = false;
									
								}

								
							}

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Error occurred while communicating with server");
								
							}

						}

				);
				if (check && check1) {
					//System.out.println("inside check");
					NUbutton.setEnabled(false);
					a2.newuser1(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11,
							email, new AsyncCallback<String>() {

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									if (result.equals("yes")) {
										Window.alert("New User Added");
										vp1.clear();
										SecondPage s = new SecondPage();

										vp1.add(s);

										

									}
								}

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									caught.printStackTrace();
									Window.alert("No user aadded");
								}
							});

				}

			}
		});

		vp.add(fp1);
		vp1.add(vp);
	}

}