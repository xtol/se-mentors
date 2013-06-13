package com.practicum.se.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ResendEmail extends Composite{
	private VerticalPanel vp2=new VerticalPanel();
	 ReSendCodeAsync a1 = GWT.create(ReSendCode.class);
	 SendMailServiceAsync jx = GWT.create(SendMailService.class);
	 LoginServiceAsync jx1 =GWT.create(LoginService.class);
	public ResendEmail(final String email,final String code)
	{
		initWidget(this.vp2);
		 vp2.setWidth("1300px");
		 vp2.setHeight("200px");
		 vp2.addStyleName("abp1");
		 vp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		 vp2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
			/// if user did half registration
			a1.checkHalfRegistered(email, code, new AsyncCallback<String>()
					{

						@Override
						public void onFailure(Throwable caught) {
							
							
						}

						@Override
						public void onSuccess(String result) {
							
							
							if (result.equals("yes"))
							{
								a1.checkRegistered(email,new AsyncCallback<String>()
										{

											@Override
											public void onFailure(
													Throwable caught) {
												
												
											}

											@Override
											public void onSuccess(String result) {
												
												if(result.equals("no"))
												{
													vp2.clear();
													final Label ReEmail = new Label("already you registered with this email-ID");		
													final Label ReEmail1 = new Label("To complete your Registration");	
													Anchor ReSend = new Anchor("Click Here");
													final Label ReEmail2 = new Label("It will re-send the verification code to Your Email-ID");
							                              
													
										    		final FlexTable fp=new FlexTable();
										    		fp.setWidget(1, 0,ReEmail );
										    		fp.setWidget(2, 0,ReEmail1 );
										    		fp.setWidget(3, 0,ReSend );
										    		fp.setWidget(4, 0,ReEmail2 );
										    		fp.setCellSpacing(20);
										    		final Image image = new Image();
													 image.setUrl("images/load.gif");
										    		ReSend.addClickHandler(new ClickHandler()
										    		{

														@Override
														public void onClick(ClickEvent event) {
															
															fp.setWidget(5,0,image);
															
															jx.sendMail(email,code,  new AsyncCallback<String>()
																	{
																
																		@Override
																		public void onFailure(Throwable caught) {
																			
																			System.out.println(caught);
																			Window.alert("failed in on failure--->wrong email ");
																			
																		}

																		@Override
																		public void onSuccess(String result){
																			
																			 if(result.equals("true"))
																		     {
																				 fp.clearCell(5,0);
																				Window.alert("Verification code is sent Please check your mail");
																				vp2.clear();
																                NewUser n=new NewUser(email);
																			         try{
																			       
																			        	 vp2.add(n);
																			         }
																			         catch(Exception e)
																			         {
																			        	 e.printStackTrace();
																			         }
																			
																				jx1.updateCode(email, code,new AsyncCallback<Void>()
																						{

																							@Override
																							public void onFailure(
																									Throwable caught) {
																								
																								
																							}

																							@Override
																							public void onSuccess(
																									Void result) {
																								
																								
																							}
																					
																						});
																		     }
																			 if(result.equals("false"))
																		     {
																				 Window.alert("failed");
																		     }
																		}
																
																	});
															}
										    			
										    		});
										    		vp2.add(fp);
												}
												else
												{
													
													vp2.clear();
													Anchor anchor = new Anchor("Click to LOGIN",
							                                 false,
							                                 "http://127.0.0.1:8888/PracticumSE.html?gwt.codesvr=127.0.0.1:9997");
													Label sp=new Label("you have already registered");
													
													
													vp2.add(sp);
													vp2.add(anchor);
												}
											}
									
								});
							}
						}				
					}
			);								
	}
}
