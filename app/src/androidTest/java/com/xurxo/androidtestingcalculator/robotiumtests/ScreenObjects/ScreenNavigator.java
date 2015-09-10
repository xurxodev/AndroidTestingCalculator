package com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects;

import com.xurxo.androidtestingcalculator.R;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.closeDrawer;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

public class ScreenNavigator {

    public ScreenNavigator verifyIsOpen(){
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        return this;
    }

    public ScreenNavigator verifyIsClosed(){
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        return this;
    }

    public ScreenNavigator open(){
        openDrawer(R.id.drawer_layout);

        return this;
    }

    public ScreenNavigator close(){
        closeDrawer(R.id.drawer_layout);

        return this;
    }

    public <T extends ScreenObject> T to(Class<T> type, int menuPosition) {

        onData(anything()).atPosition(menuPosition).perform(click());

        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
