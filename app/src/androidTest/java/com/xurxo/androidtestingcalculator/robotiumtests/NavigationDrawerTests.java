package com.xurxo.androidtestingcalculator.robotiumtests;


import android.graphics.Point;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;

import com.robotium.solo.Solo;
import com.xurxo.androidtestingcalculator.R;
import com.xurxo.androidtestingcalculator.presentation.activities.MainActivity;
import com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects.AboutScreen;
import com.xurxo.androidtestingcalculator.robotiumtests.ScreenObjects.CalculatorScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTests {

    CalculatorScreen calculatorScreen;

    @Before
    public void setUp() throws Exception {
        calculatorScreen = new CalculatorScreen();

        calculatorScreen.start();
    }

    @After
    public void tearDown() throws Exception {
        calculatorScreen.finish();
    }


    @Test
    public void openAndCloseDrawer_ShouldWork() {

        boolean isClosed;
        boolean isOpen;

        isClosed = calculatorScreen
                .navigation()
                .isClosed();

        assertThat(isClosed, is(true));

       isOpen = calculatorScreen
                .navigation()
                .open()
                .isOpen();

        assertThat(isOpen, is(true));

        isClosed = calculatorScreen
                .navigation()
                .close()
                .isClosed();

        assertThat(isClosed, is(true));
    }


    @Test
    public void navigateToAbout_TitleShouldBeAbout() {
        String aboutText = "About";

        String title = calculatorScreen
                .navigateToAbout()
                .getTitle();

        assertThat(title, is(aboutText));
    }


    @Test
    public void navigateToAbout_ContentShouldBeOfAbout() {
        AboutScreen about = calculatorScreen.navigateToAbout();

        assertThat(about.NameAndVersionIsDisplayed(), is(true));
        assertThat(about.DescriptionIsDisplayed(), is(true));
    }
}
