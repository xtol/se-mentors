package com.practicum.se.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.practicum.se.shared.FieldVerifier;

public class SecondPage extends Composite{
	private VerticalPanel vp=new VerticalPanel();

	 LoginServiceAsync a1 = GWT.create(LoginService.class);
	 RegistrationServiceAsync a2 = GWT.create(RegistrationService.class);
	 SendMailServiceAsync jx = GWT.create(SendMailService.class);

	public SecondPage()
	{
		initWidget(this.vp);
		HorizontalPanel hp2=new HorizontalPanel();
	
		HorizontalPanel hp3=new HorizontalPanel();
		hp3.setWidth("50px");
		
		HorizontalPanel hp=new HorizontalPanel();
		hp.setStyleName("abp1");
		hp.setWidth("600px");
		hp.setHeight("400px");
		hp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		
		final HorizontalPanel hp1=new HorizontalPanel();
		hp1.setStyleName("abp1");
		hp1.setWidth("650px");
		hp1.setHeight("400px");
		hp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		hp1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		
		final FlexTable fp=new FlexTable();
		final VerticalPanel vp1=new VerticalPanel();
		final Label Loginlb = new Label("Email");
		final Label Pwdlb = new Label("Password");
		final TextBox LoginEmail = new TextBox();
		final ExtendedPasswordTextBox LoginPwd = new ExtendedPasswordTextBox();
		final Button LoginButton = new Button("LogIn");
		
		Label Signin =new Label("SignIn/Login");
		vp1.setSpacing(10);
		Signin.setStyleName("add");
	
		LoginEmail.setWidth("170px");
		
		HTML H=new HTML();
		fp.setCellSpacing(7);
		H.setWidth("7px");
		H.setHeight("30px");
		
		vp1.add(Signin);
		LoginPwd.setWidth("170px");
		fp.setWidget(0, 0, Loginlb);
		
		fp.setWidget(0, 1, LoginEmail);
		fp.setWidget(2, 0, Pwdlb);
		
		fp.setWidget(2, 1, LoginPwd);
		fp.setWidget(5, 1, LoginButton);
		Anchor signup=new Anchor("Don't have an account?");
		
		
		Anchor forgot=new Anchor("Forgot Password?");
		forgot.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				vp.clear();
				ForgotPage fp=new ForgotPage();
				vp.add(fp);
				}});
		 
		vp1.add(fp);
		 vp1.add(signup);
		 vp1.add(forgot);
		 hp.add(vp1);
		 
		 FlexTable fp1=new FlexTable();
		 final Label Fnamelb = new Label("First Name");
			final Label Mnamelb = new Label("Middle Name");
			final Label Lnamelb = new Label("Last Name");
			final Label EnterEmaillb = new Label("Enter Your Email");
			final Label ReenterEmaillb = new Label("Re-enter Email");
			final Button SignUpButton = new Button("SIGNUP");
			SignUpButton.setWidth("100px");
			
			final TextBox FnameTextBox = new TextBox();
			final TextBox MnameTextBox = new TextBox();
			final TextBox LnameTextBox = new TextBox();
			final TextBox EnterEmailTextBox = new TextBox();
			final TextBox ReenterEmailTextBox = new ExtendedTextBox();

		 VerticalPanel vp2=new VerticalPanel();
		 Label l1=new Label("SignUp");
			vp2.setSpacing(10);
			fp1.setCellSpacing(7);
		 fp1.setWidget(0, 0,Fnamelb); fp1.setWidget(0, 1,Mnamelb); fp1.setWidget(0, 2,Lnamelb);
		 fp1.setWidget(1, 0,FnameTextBox);  fp1.setWidget(1, 1,MnameTextBox);  fp1.setWidget(1, 2,LnameTextBox);
		 fp1.setWidget(2, 0,EnterEmaillb );  fp1.setWidget(2, 1,EnterEmailTextBox );
		 fp1.setWidget(3, 0,ReenterEmaillb );  fp1.setWidget(3, 1,ReenterEmailTextBox );
		 fp1.setWidget(5, 0,SignUpButton );
		 l1.setStyleName("add");
		 vp2.add(l1);
		 vp2.add(fp1);
		 hp2.add(hp);
			hp2.add(hp3);
			hp1.add(vp2);
			hp2.add(hp1);
			vp.add(hp2);
			SignUpButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event) {
					
					
					
					final String s1 = FnameTextBox.getText();
					final String s2 = MnameTextBox.getText();
					final String s3 = LnameTextBox.getText();
					final String s4 = EnterEmailTextBox.getText();
					String s5 =null;
					UsernameGen name= new UsernameGen();
					name.pass_name(s1,s3);
					UsernameGen ug=new UsernameGen();
					s5=ug.code_generate();
					final String code_s=s5;
					System.out.println("in authentication---s5--"+s5);
					a2.newuser(s1, s2, s3, s4, s5,
							new AsyncCallback<String>() {

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									if (result.equals("yes")) {
										
										
										
										jx.sendMail(s4,code_s,  new AsyncCallback<String>()
												{
											
													@Override
													public void onFailure(Throwable caught) {
														// TODO Auto-generated method stub
														//System.out.println(caught);
														Window.alert("invalid emailid");
														
													}

													@Override
													public void onSuccess(String result){
														// TODO Auto-generated method stub
														 if(result.equals("true"))
													     {
															 System.out.println("hiiiiiiii testing in login screen");
													   Window.alert("code is sent to your mail");
													   vp.clear();
													      NewUser n=new NewUser(s4);
													         try{
													        	 
													        	 vp.add(n);
													         }
													         catch(Exception e)
													         {
													        	 e.printStackTrace();
													        	 System.out.println("about setvisible");
													         }
													
													 
													     }
														 if(result.equals("false"))
													     {
															 System.out.println("hiiiiiiii testing in login screen NNO");
															 Window.alert("invalid emailid");
															
													     }
													}
											
												});

										
									}
									else
									{
										
										vp.clear();
										ResendEmail re=new ResendEmail(s4,code_s);
										vp.add(re);
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
			});
			LoginButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
				final String s1 = LoginEmail.getText();
				final String s2 = LoginPwd.getText();
				
				if (!FieldVerifier.isValidName(s1,s2)) {
					System.out.println("label");
					Label errorLabel=new Label(); 
					
					errorLabel.setText("Please enter correct username or password");
					fp.setWidget(4, 1, errorLabel);
					return;
				}
				
				
				
				else{
					a1.check(s1, s2, new AsyncCallback<String>() {

						@Override
						public void onSuccess(String result) {
							// TODO Auto-generated method stub
							if (result.equals("yes"))
							{
								Window.alert("Result ok");
								vp.clear();
								 //create contents for tabs of tabpanel
								 TabPanel tabPanel = new TabPanel();
							      //create titles for tabs
							      String tab1Title = "Profile";
							      String tab2Title = "Search";
							      String tab3Title = "Settings";
							      tabPanel.setWidth("600px");
							    
							      tabPanel.setHeight("300px");
							     
							      
									test1 t1=new test1(s1);
									 tabPanel.add(t1, tab1Title);
									  tabPanel.selectTab(0);
									 
									 
								UserAccount n=new UserAccount(s1);
								tabPanel.add(n, tab2Title);
							
								 
								
								
								UpdateAccount n1=new UpdateAccount(s1);
								tabPanel.add(n1, tab3Title);
								
								 
								 
									  vp.add(tabPanel);
								
								
							} 
							else {
								Window.alert("Wrong Entry");
							}

						}

						@Override
						public void onFailure(Throwable caught) {

							Window.alert("Result not ok");
						}
					});
				}
				}
			});
		 
			signup.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
					vp.clear();
					vp.add(hp1);
					
				}});
	}
	
	private class ExtendedPasswordTextBox extends PasswordTextBox {

		public ExtendedPasswordTextBox() {
			super();

			sinkEvents(Event.ONPASTE);
		}

		@Override
		public void onBrowserEvent(Event event) {
			
			super.onBrowserEvent(event);
			switch (DOM.eventGetType(event)) {
			case Event.ONPASTE:
				Window.alert("Don't Paste. Please enter Password");
				event.stopPropagation();  
                event.preventDefault();  
                break;  
			}
		}
	}

	private class ExtendedTextBox extends TextBox {

		public ExtendedTextBox() {
			super();

			sinkEvents(Event.ONPASTE);
		}

		@Override
		public void onBrowserEvent(Event event) {
			
			super.onBrowserEvent(event);
			switch (DOM.eventGetType(event)) {
			case Event.ONPASTE:
				Window.alert("Don't Paste. Please Re-enter Email");
				event.stopPropagation();  
                event.preventDefault();  
                break;  
			}
		}
	}


}
