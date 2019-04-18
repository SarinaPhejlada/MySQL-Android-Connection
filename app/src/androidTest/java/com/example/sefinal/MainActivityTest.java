package com.example.sefinal;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity activity;
    private EditText username;
    private EditText password;
    private TextView loginMessage;
    Instrumentation.ActivityMonitor registerMonitor = getInstrumentation().addMonitor(StudentRegistration.class.getName(), null, false);
    Instrumentation.ActivityMonitor homeMonitor = getInstrumentation().addMonitor(StudentHomePage.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        activity = rule.getActivity();
        username = activity.studentUsername;
        password = activity.studentPassword;
        loginMessage = activity.loginMessage;
    }

    @After
    public void tearDown() throws Exception {
        activity = null;
    }

    @Test
    public void registerLinkTest(){
        onView(withId(R.id.registerLink)).perform(click());
        Activity registerActivity = getInstrumentation().waitForMonitorWithTimeout(registerMonitor, 5000);
        assertNotNull(registerActivity);
        registerActivity.finish();
    }

    @Test
    public void missingEmailTest(){
        onView(withId(R.id.username)).perform(typeText("\n"));
        onView(withId(R.id.password)).perform(typeText("\n"));
        onView(withId(R.id.loginBtn)).perform(click());
        assertEquals("Check Missing Input Value!!!", loginMessage.getText());
    }

    @Test
    public void successfulLoginTest(){
        onView(withId(R.id.username)).perform(typeText("sarinap\n"));
        onView(withId(R.id.password)).perform(typeText("password\n"));
        onView(withId(R.id.loginBtn)).perform(click());
        Activity homeActivity = getInstrumentation().waitForMonitorWithTimeout(homeMonitor, 5000);
        assertNotNull(homeActivity);
        homeActivity.finish();
    }

}