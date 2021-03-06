package com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects;


import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.widget.Button;
import android.widget.TextView;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.Rule;

public class CalculatorScreen extends ScreenObject{

    public CalculatorScreen start(){

        mainActivityRule = new ActivityTestRule<>(MainActivity.class,true,false);
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), mainActivityRule.getActivity());
        navigator = new ScreenNavigator(mainActivityRule,solo);

        mainActivityRule.launchActivity(null);

        return this;
    }

    public CalculatorScreen finish(){
        solo.finishOpenedActivities();

        return this;
    }

    public AboutScreen navigateToAbout(){
        navigation().open();

        navigation().to("About");

        return new AboutScreen(mainActivityRule,solo);
    }


    public String getTitle() {
        return (String) mainActivityRule.getActivity().getTitle();
    }

    public String getDisplay(){
        return (String) ((TextView) solo.getView(R.id.display_TextView)).getText();
    }

    public boolean buttonIsDisplayed(String text){
        Button expectedButton;

        expectedButton = solo.getButton(text,true);

        return expectedButton != null;
    }

    public CalculatorScreen pressNumber(String number){
        solo.clickOnView(solo.getButton(number));

        return this;
    }

    public CalculatorScreen pressOperation(String operator){
        solo.clickOnView(solo.getButton(operator));
        return this;
    }

    public CalculatorScreen pressEqual(){
        solo.clickOnView(solo.getView(R.id.equal_button));

        return this;
    }

}
