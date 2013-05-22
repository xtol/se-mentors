package com.practicum.se.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;


public class HandleEvents1 extends Composite {
  private static HandleEvents1UiBinder uiBinder = GWT
      .create(HandleEvents1UiBinder.class);

  interface HandleEvents1UiBinder extends UiBinder<Widget, HandleEvents1> {
  }

  
  

  @UiField
 static ListBox stateList;

  @UiField
  static ListBox cityList;

  public HandleEvents1() {
    initWidget(uiBinder.createAndBindUi(this));
   // numberButton.addClickHandler(new RanNumHandler());
    listSetup();
  }

  

  private void listSetup() {
    populateStateList();
    stateList.setVisibleItemCount(1);
    cityList.addItem("Select City");
    cityList.setVisibleItemCount(1);
    cityList.setEnabled(false);
    stateList.addChangeHandler(new StateHandler());
  }

  private void populateStateList() {
    stateList.addItem("Select State");
    StateInfo[] nearbyStates = StateInfo.getNearbyStates();
    for (StateInfo state : nearbyStates) {
      stateList.addItem(state.getStateName());
    }
  }

  private class StateHandler implements ChangeHandler {
    @Override
    public void onChange(ChangeEvent event) {
      int index = stateList.getSelectedIndex();
      String state = stateList.getItemText(index);
      StateInfo[] nearbyStates = StateInfo.getNearbyStates();
      String[] cities = StateInfo.findCities(nearbyStates, state);
      cityList.clear();
      for (String city : cities) {
        cityList.addItem(city);
      }
      cityList.setEnabled(true);
    }
  }
}
