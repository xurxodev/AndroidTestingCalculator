package com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects;

import android.graphics.Point;
import android.support.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.Rule;


public class ScreenNavigator {

    private Solo solo;
    @Rule
    protected ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class,true,false);

    public ScreenNavigator(ActivityTestRule<MainActivity> mainActivityRule, Solo solo) {
        this.solo = solo;
        this.mainActivityRule = mainActivityRule;
    }


    public boolean isOpen(){
        return solo.getView(R.id.navigation).isShown();
    }

    public boolean isClosed(){
        return !solo.getView(R.id.navigation).isShown();
    }

    public ScreenNavigator open(){
        setDrawer(true);

        return this;
    }

    public ScreenNavigator close(){
        setDrawer(false);

        return this;
    }

    public ScreenNavigator to(String menuText) {

        setDrawer(true);

        solo.clickOnMenuItem(menuText);

        return this;
    }

    private void setDrawer(boolean open) {
        Point deviceSize = new Point();

        mainActivityRule.getActivity().getWindowManager().getDefaultDisplay().getSize(deviceSize);

        int screenWidth = deviceSize.x;
        int screenHeight = deviceSize.y;
        int fromX = 0;
        int toX = screenWidth / 2;
        int fromY = screenHeight / 2;
        int toY = fromY;

        if (open)
            solo.drag(fromX, toX, fromY, toY, 1);
        else
            solo.drag(toX,fromX,fromY, toY, 1);
    }
}
