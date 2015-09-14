package com.xurxo.androidtestingcalculator.robotiumtests;


import android.graphics.Point;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTests {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    private Solo solo;

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), mainActivityRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @Test
    public void openAndCloseDrawer_ShouldWork() {
        //solo methods for navigation not working, get drawer layout with getView
        DrawerLayout drawerLayout = (DrawerLayout) solo.getView(R.id.drawer_layout);

        assertThat(isDrawerOpen(), is(false));

        setDrawer(true);

        assertThat(isDrawerOpen(), is(true));

        setDrawer(false);

        assertThat(isDrawerOpen(), is(false));

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

    private boolean isDrawerOpen() {
        return solo.getView(R.id.navigation).isShown();
    }


    @Test
    public void navigateToAbout_TitleShouldBeAbout() {
        String aboutText = "About";

        setDrawer(true);

        solo.clickOnMenuItem(aboutText);

        solo.waitForView(R.id.about_description);

        String title = (String) mainActivityRule.getActivity().getTitle();

        assertThat(title, is(aboutText));
    }


    @Test
    public void navigateToAbout_ContentShouldBeOfAbout() {
        String aboutText = "About";

        setDrawer(true);

        solo.clickOnMenuItem(aboutText);

        assertThat(solo.getView(R.id.about_app_name_and_version).isShown(), is(true));
        assertThat(solo.getView(R.id.about_description).isShown(), is(true));
    }
}
