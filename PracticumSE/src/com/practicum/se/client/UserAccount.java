package com.practicum.se.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UserAccount extends Composite {
	private VerticalPanel vp2 = new VerticalPanel();
	SearchFriendServiceAsync a1 = GWT.create(SearchFriendService.class);
	FriendDetailsServiceAsync a2 = GWT.create(FriendDetailsService.class);

	MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();

	public UserAccount(final String s1) {
		initWidget(this.vp2);
		vp2.setWidth("1300px");
		
		HorizontalPanel hp = new HorizontalPanel();

		a1.getNames(s1, new AsyncCallback<ArrayList<String>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("some problem in useraccount");

			}

			@Override
			public void onSuccess(ArrayList<String> result) {
				// TODO Auto-generated method stub

				for (int i = 0; i < result.size(); i++) {

					oracle.add(result.get(i));
					System.out.println("in useraccount  " + result.get(i));

				}

			}

		});

		Label UAwellb = new Label("Welcome " + s1);
		hp.add(UAwellb);
		Label jj = new Label("");
		jj.setWidth("10px");
		hp.add(jj);
		Label UAAddfriendlb = new Label("Search Friend ");
		hp.add(UAAddfriendlb);

		final SuggestBox UAAddfriendtb = new SuggestBox(oracle);
		UAAddfriendtb.setWidth("200");
		hp.add(UAAddfriendtb);
		vp2.add(hp);
		final FlexTable fp = new FlexTable();
		fp.setCellPadding(10);
		fp.setCellSpacing(10);
		fp.addStyleName("pp");
		UAAddfriendtb.addSelectionHandler(new SelectionHandler<Suggestion>() {

			@Override
			public void onSelection(SelectionEvent<Suggestion> event) {
				// TODO Auto-generated method stub

				System.out.println("suggestbox"
						+ UAAddfriendtb.getText().toString());

				a2.FriendDetails(UAAddfriendtb.getText().toString(),
						new AsyncCallback<HashMap<String, String>>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}

							@SuppressWarnings("rawtypes")
							@Override
							public void onSuccess(HashMap<String, String> result) {
								fp.clear();
								// TODO Auto-generated method stub
								Set<?> set = result.entrySet();
								// Get an iterator
								Iterator<?> i = set.iterator();
								int j = 0, k = 0;

								while (i.hasNext()) {

									Map.Entry me = (Map.Entry) i.next();
									System.out.println("0000====" + me.getKey()
											+ "----" + me.getValue());

									if (me.getKey().equals("username")) {
										final Label test = new Label();
										test.setText("Username	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test);
										j++;
									}
									if (me.getKey().equals("firstname")) {
										final Label test1 = new Label();
										test1.setText("firstname	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test1);
										j++;
									}
									if (me.getKey().equals("middlename")) {
										final Label test2 = new Label();
										test2.setText("middlename	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test2);
										j++;
									}
									if (me.getKey().equals("lastname")) {
										final Label test3 = new Label();
										test3.setText("lastname	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test3);
										j++;
									}
									if (me.getKey().equals("gender")) {
										final Label test4 = new Label();
										test4.setText("gender	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test4);
										j++;
									}
									if (me.getKey().equals("country")) {
										final Label test5 = new Label();
										test5.setText("country	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test5);
										j++;
									}
									if (me.getKey().equals("city")) {
										final Label test6 = new Label();
										test6.setText("city	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test6);
										j++;
									}
									if (me.getKey().equals("pincode")) {
										final Label test7 = new Label();
										test7.setText("pincode	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test7);
										j++;
									}
									if (me.getKey().equals("address")) {
										final Label test8 = new Label();
										test8.setText("address	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test8);
										j++;
									}
									if (me.getKey().equals("phonenum")) {
										final Label test9 = new Label();
										test9.setText("phonenum	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test9);
										j++;
									}

									if (me.getKey().equals("dob")) {
										final Label test10 = new Label();
										test10.setText("dob	:	"
												+ me.getValue().toString());

										fp.setWidget(j, k, test10);
										j++;
									}

								}
							}

						});

			}

		});

		vp2.add(fp);
	}

}
