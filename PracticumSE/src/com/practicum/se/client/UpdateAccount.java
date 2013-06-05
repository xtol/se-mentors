package com.practicum.se.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UpdateAccount extends Composite {
	private VerticalPanel vp2 = new VerticalPanel();
	UserDetailsServiceAsync a2 = GWT.create(UserDetailsService.class);

	@SuppressWarnings("deprecation")
	public UpdateAccount(final String s1) {
		initWidget(this.vp2);
		// TODO Auto-generated constructor stub
		vp2.setWidth("1300px");
		vp2.setHeight("500px");
		vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		final FlexTable fp = new FlexTable();
		fp.setCellPadding(10);
		fp.setCellSpacing(10);
		fp.addStyleName("pp");

		
		CheckBox cbUpUnametb = new CheckBox("Update Username");
		cbUpUnametb.setChecked(true);
		final ListBox lUpuname = new ListBox();

		final TextBox UpUnametb = new TextBox();
		a2.getUsername(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				UpUnametb.setText(result);
			}

		}

		);
		a2.getPUsername(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpuname.addItem("Public", "1");
					lUpuname.addItem("Private", "0");
				} else {
					lUpuname.addItem("Private", "0");
					lUpuname.addItem("Public", "1");
				}
			}

		});
		UpUnametb.setEnabled(false);
		lUpuname.setEnabled(false);
		// Hook up a handler to find out when it's clicked.
		cbUpUnametb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					UpUnametb.setEnabled(true);
					lUpuname.setEnabled(true);
				} else {
					UpUnametb.setEnabled(false);
					lUpuname.setEnabled(false);
				}
			}
		});

		// absolutePanel.add(cbUpUnametb,100,100);
		// absolutePanel.add(UpUnametb,300,100);
		// absolutePanel.add(lUpuname,500,100);

		fp.setWidget(1, 0, cbUpUnametb);
		fp.setWidget(1, 1, UpUnametb);
		fp.setWidget(1, 2, lUpuname);

		// ///////fname//////////////
		CheckBox cbUpfnametb = new CheckBox("Update Firstname");
		final TextBox Upfnametb = new TextBox();
		final ListBox lUpfname = new ListBox();
		cbUpfnametb.setChecked(false);
		Upfnametb.setEnabled(false);
		lUpfname.setEnabled(false);
		a2.getFname(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Upfnametb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpfnametb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Upfnametb.setEnabled(true);
					lUpfname.setEnabled(true);
				} else {
					Upfnametb.setEnabled(false);
					lUpfname.setEnabled(false);
				}
			}
		});
		a2.getPFname(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpfname.addItem("Public", "1");
					lUpfname.addItem("Private", "0");
				} else {
					lUpfname.addItem("Private", "0");
					lUpfname.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpfnametb,100,150);
		// absolutePanel.add(Upfnametb,300,150);
		// absolutePanel.add(lUpfname,500,150);
		fp.setWidget(2, 0, cbUpfnametb);
		fp.setWidget(2, 1, Upfnametb);
		fp.setWidget(2, 2, lUpfname);

		// ///////mname//////////////
		CheckBox cbUpmnametb = new CheckBox("Update Middlename");
		final TextBox Upmnametb = new TextBox();
		final ListBox lUpmname = new ListBox();
		cbUpmnametb.setChecked(false);
		Upmnametb.setEnabled(false);
		lUpmname.setEnabled(false);
		a2.getMname(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Upmnametb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpmnametb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Upmnametb.setEnabled(true);
					lUpmname.setEnabled(true);
				} else {
					Upmnametb.setEnabled(false);
					lUpmname.setEnabled(false);
				}
			}
		});
		a2.getPMname(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpmname.addItem("Public", "1");
					lUpmname.addItem("Private", "0");
				} else {
					lUpmname.addItem("Private", "0");
					lUpmname.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpmnametb,100,200);
		// absolutePanel.add(Upmnametb,300,200);
		// absolutePanel.add(lUpmname,500,200);

		fp.setWidget(3, 0, cbUpmnametb);
		fp.setWidget(3, 1, Upmnametb);
		fp.setWidget(3, 2, lUpmname);

		// ///////lname//////////////
		CheckBox cbUplnametb = new CheckBox("Update Lastname");
		final TextBox Uplnametb = new TextBox();
		final ListBox lUplname = new ListBox();
		cbUplnametb.setChecked(false);
		Uplnametb.setEnabled(false);
		lUplname.setEnabled(false);
		a2.getLname(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Uplnametb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUplnametb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Uplnametb.setEnabled(true);
					lUplname.setEnabled(true);
				} else {
					Uplnametb.setEnabled(false);
					lUplname.setEnabled(false);
				}
			}
		});
		a2.getPLname(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUplname.addItem("Public", "1");
					lUplname.addItem("Private", "0");
				} else {
					lUplname.addItem("Private", "0");
					lUplname.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUplnametb,100,250);
		// absolutePanel.add(Uplnametb,300,250);
		// absolutePanel.add(lUplname,500,250);

		fp.setWidget(4, 0, cbUplnametb);
		fp.setWidget(4, 1, Uplnametb);
		fp.setWidget(4, 2, lUplname);

		// ///////dob//////////////
		CheckBox cbUpdobtb = new CheckBox("Update date of birth");
		final TextBox Updobtb = new TextBox();
		final ListBox lUpdob = new ListBox();
		cbUpdobtb.setChecked(false);
		Updobtb.setEnabled(false);
		lUpdob.setEnabled(false);
		a2.getDob(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Updobtb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpdobtb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Updobtb.setEnabled(true);
					lUpdob.setEnabled(true);
				} else {
					Updobtb.setEnabled(false);
					lUpdob.setEnabled(false);
				}
			}
		});
		a2.getPDob(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpdob.addItem("Public", "1");
					lUpdob.addItem("Private", "0");
				} else {
					lUpdob.addItem("Private", "0");
					lUpdob.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpdobtb,100,300);
		// absolutePanel.add(Updobtb,300,300);
		// absolutePanel.add(lUpdob,500,300);

		fp.setWidget(5, 0, cbUpdobtb);
		fp.setWidget(5, 1, Updobtb);
		fp.setWidget(5, 2, lUpdob);

		// ///////city//////////////
		CheckBox cbUpcitytb = new CheckBox("Update city");
		final TextBox Upcitytb = new TextBox();
		final ListBox lUpcity = new ListBox();
		cbUpcitytb.setChecked(false);
		Upcitytb.setEnabled(false);
		lUpcity.setEnabled(false);
		a2.getCity(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Upcitytb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpcitytb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Upcitytb.setEnabled(true);
					lUpcity.setEnabled(true);
				} else {
					Upcitytb.setEnabled(false);
					lUpcity.setEnabled(false);
				}
			}
		});
		a2.getPCity(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpcity.addItem("Public", "1");
					lUpcity.addItem("Private", "0");
				} else {
					lUpcity.addItem("Private", "0");
					lUpcity.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpcitytb,100,350);
		// absolutePanel.add(Upcitytb,300,350);
		// absolutePanel.add(lUpcity,500,350);

		fp.setWidget(6, 0, cbUpcitytb);
		fp.setWidget(6, 1, Upcitytb);
		fp.setWidget(6, 2, lUpcity);

		// ///////country//////////////
		CheckBox cbUpcountrytb = new CheckBox("Update country");
		final TextBox Upcountrytb = new TextBox();
		final ListBox lUpcountry = new ListBox();
		cbUpcountrytb.setChecked(false);
		Upcountrytb.setEnabled(false);
		lUpcountry.setEnabled(false);
		a2.getCountry(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Upcountrytb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpcountrytb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Upcountrytb.setEnabled(true);
					lUpcountry.setEnabled(true);
				} else {
					Upcountrytb.setEnabled(false);
					lUpcountry.setEnabled(false);
				}
			}
		});
		a2.getPCountry(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpcountry.addItem("Public", "1");
					lUpcountry.addItem("Private", "0");
				} else {
					lUpcountry.addItem("Private", "0");
					lUpcountry.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpcountrytb,100,400);
		// absolutePanel.add(Upcountrytb,300,400);
		// absolutePanel.add(lUpcountry,500,400);

		fp.setWidget(7, 0, cbUpcountrytb);
		fp.setWidget(7, 1, Upcountrytb);
		fp.setWidget(7, 2, lUpcountry);

		// ///////address//////////////
		CheckBox cbUpaddresstb = new CheckBox("Update address");
		final TextBox Upaddresstb = new TextBox();
		final ListBox lUpaddress = new ListBox();
		cbUpaddresstb.setChecked(false);
		Upaddresstb.setEnabled(false);
		lUpaddress.setEnabled(false);
		a2.getAddress(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Upaddresstb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpaddresstb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Upaddresstb.setEnabled(true);
					lUpaddress.setEnabled(true);
				} else {
					Upaddresstb.setEnabled(false);
					lUpaddress.setEnabled(false);
				}
			}
		});
		a2.getPAddress(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpaddress.addItem("Public", "1");
					lUpaddress.addItem("Private", "0");
				} else {
					lUpaddress.addItem("Private", "0");
					lUpaddress.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpaddresstb,100,450);
		// absolutePanel.add(Upaddresstb,300,450);
		// absolutePanel.add(lUpaddress,500,450);

		fp.setWidget(8, 0, cbUpaddresstb);
		fp.setWidget(8, 1, Upaddresstb);
		fp.setWidget(8, 2, lUpaddress);

		// ///////pincode//////////////
		CheckBox cbUppincodetb = new CheckBox("Update pincode");
		final TextBox Uppincodetb = new TextBox();
		final ListBox lUppincode = new ListBox();
		cbUppincodetb.setChecked(false);
		Uppincodetb.setEnabled(false);
		lUppincode.setEnabled(false);
		a2.getPincode(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Uppincodetb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUppincodetb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Uppincodetb.setEnabled(true);
					lUppincode.setEnabled(true);
				} else {
					Uppincodetb.setEnabled(false);
					lUppincode.setEnabled(false);
				}
			}
		});
		a2.getPPincode(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUppincode.addItem("Public", "1");
					lUppincode.addItem("Private", "0");
				} else {
					lUppincode.addItem("Private", "0");
					lUppincode.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUppincodetb,100,500);
		// absolutePanel.add(Uppincodetb,300,500);
		// absolutePanel.add(lUppincode,500,500);

		fp.setWidget(9, 0, cbUppincodetb);
		fp.setWidget(9, 1, Uppincodetb);
		fp.setWidget(9, 2, lUppincode);

		// ///////phonenum//////////////
		CheckBox cbUpphnotb = new CheckBox("Update phone number");
		final TextBox Upphnotb = new TextBox();
		final ListBox lUpphno = new ListBox();
		cbUpphnotb.setChecked(false);
		Upphnotb.setEnabled(false);
		lUpphno.setEnabled(false);
		a2.getPhone(s1, new AsyncCallback<String>()

		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Upphnotb.setText(result);
			}

		}

		);
		// Hook up a handler to find out when it's clicked.
		cbUpphnotb.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				boolean checked = ((CheckBox) event.getSource()).isChecked();

				if (checked) {
					Upphnotb.setEnabled(true);
					lUpphno.setEnabled(true);
				} else {
					Upphnotb.setEnabled(false);
					lUpphno.setEnabled(false);
				}
			}
		});
		a2.getPPhone(s1, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				if (result) {
					lUpphno.addItem("Public", "1");
					lUpphno.addItem("Private", "0");
				} else {
					lUpphno.addItem("Private", "0");
					lUpphno.addItem("Public", "1");
				}
			}

		});

		// absolutePanel.add(cbUpphnotb,100,550);
		// absolutePanel.add(Upphnotb,300,550);
		// absolutePanel.add(lUpphno,500,550);

		fp.setWidget(10, 0, cbUpphnotb);
		fp.setWidget(10, 1, Upphnotb);
		fp.setWidget(10, 2, lUpphno);

		final Button UpdateButton = new Button();
		UpdateButton.setText("Update");
		// absolutePanel.add(UpdateButton,100,650);
		fp.setWidget(11, 1, UpdateButton);

		UpdateButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String ub1 = UpUnametb.getText();
				int ppr1 = lUpuname.getSelectedIndex();
				String ubppr1 = lUpuname.getValue(ppr1);

				System.out.println("-----to check list value---" + ubppr1);

				String ub2 = Upfnametb.getText();
				int ppr2 = lUpfname.getSelectedIndex();
				String ubppr2 = lUpfname.getValue(ppr2);

				String ub3 = Upmnametb.getText();
				int ppr3 = lUpmname.getSelectedIndex();
				String ubppr3 = lUpmname.getValue(ppr3);

				String ub4 = Uplnametb.getText();
				int ppr4 = lUplname.getSelectedIndex();
				String ubppr4 = lUplname.getValue(ppr4);

				String ub5 = Updobtb.getText();
				int ppr5 = lUpdob.getSelectedIndex();
				String ubppr5 = lUpdob.getValue(ppr5);

				String ub6 = Upcitytb.getText();
				int ppr6 = lUpcity.getSelectedIndex();
				String ubppr6 = lUpcity.getValue(ppr6);

				String ub7 = Upcountrytb.getText();
				int ppr7 = lUpcountry.getSelectedIndex();
				String ubppr7 = lUpcountry.getValue(ppr7);

				String ub8 = Upaddresstb.getText();
				int ppr8 = lUpaddress.getSelectedIndex();
				String ubppr8 = lUpaddress.getValue(ppr8);

				String ub9 = Uppincodetb.getText();
				int ppr9 = lUppincode.getSelectedIndex();
				String ubppr9 = lUppincode.getValue(ppr9);

				String ub10 = Upphnotb.getText();
				int ppr10 = lUpphno.getSelectedIndex();
				String ubppr10 = lUpphno.getValue(ppr10);

				a2.updateuser(ub2, ub3, ub4, s1, new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if (result == "yes") {
							System.out.println("updation fname done");
						}
					}

				});

				a2.updateuser1(s1, ub1, ub7, ub6, ub9, ub8, ub10, ub5, ub5,
						ub5, new AsyncCallback<String>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onSuccess(String result) {
								// // should change in database dob
								// TODO Auto-generated method stub
								if (result == "yes") {
									System.out.println("updation uname done");

								}

							}

						});
				a2.updatepermission(s1, Integer.parseInt(ubppr2),
						Integer.parseInt(ubppr3), Integer.parseInt(ubppr4),
						Integer.parseInt(ubppr1), Integer.parseInt(ubppr7),
						Integer.parseInt(ubppr6), Integer.parseInt(ubppr9),
						Integer.parseInt(ubppr8), Integer.parseInt(ubppr10),
						Integer.parseInt(ubppr5), new AsyncCallback<String>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onSuccess(String result) {
								// TODO Auto-generated method stub

							}

						});

				Window.alert("updated your account");
			}

		});
		vp2.add(fp);
	}

}
