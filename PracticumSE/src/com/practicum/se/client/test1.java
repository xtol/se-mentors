package com.practicum.se.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class test1 extends Composite {
	UserDetailsServiceAsync a2 = GWT.create(UserDetailsService.class);

	private VerticalPanel vp1 = new VerticalPanel();

	public test1(String s1) {
		initWidget(this.vp1);
		final FlexTable fp = new FlexTable();
		fp.setCellPadding(10);
		fp.setCellSpacing(10);
		fp.addStyleName("pp");
		
		vp1.setWidth("1300px");
		vp1.setHeight("500px");
		vp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		VerticalPanel yname1 = new VerticalPanel();
		Label yname = new Label("Your Profile Details");
		
		yname1.add(yname);
		vp1.add(yname1);

		a2.getUsername(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("some problem in useraccount uname");
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub

				Label UAunamelb = new Label("username	:	" + result);
				fp.setWidget(1, 0, UAunamelb);

			}

		});

		a2.getFname(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub

				Label UAfnamelb = new Label("First Name	:	 " + result);

				fp.setWidget(2, 0, UAfnamelb);

			}

		});
		a2.getMname(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if (result.equals(null)) {
					result = "-NA-";
				}
				Label UAmnamelb = new Label("Middle Name	:	 " + result);

				fp.setWidget(3, 0, UAmnamelb);

			}

		});
		a2.getLname(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub

				Label UAlnamelb = new Label("Last Name	:	" + result);

				fp.setWidget(4, 0, UAlnamelb);

			}

		});

		a2.getDob(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Label UAdoblb = new Label("Date Of Birth	:	" + result);

				fp.setWidget(5, 0, UAdoblb);

			}

		});

		a2.getCity(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Label UAcitylb = new Label("City	:	" + result);

				fp.setWidget(6, 0, UAcitylb);

			}

		});

		a2.getCountry(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Label UAcountrylb = new Label("Country	:	" + result);

				fp.setWidget(7, 0, UAcountrylb);

			}

		});

		a2.getPincode(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Label UApcodelb = new Label("Pincode	:	" + result);

				fp.setWidget(7, 0, UApcodelb);

			}

		});

		a2.getAddress(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub

				Label UAaddresslb = new Label("Address	:	" + result);

				fp.setWidget(8, 0, UAaddresslb);

			}

		});

		a2.getPhone(s1, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				Label UAphonelb = new Label("Phone No	:	" + result);

				fp.setWidget(9, 0, UAphonelb);
			}

		});
		vp1.add(fp);

	}
}