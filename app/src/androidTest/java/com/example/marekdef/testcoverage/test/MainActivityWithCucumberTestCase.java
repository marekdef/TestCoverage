package com.example.marekdef.testcoverage.test;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import com.example.marekdef.testcoverage.MainActivity;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by marekdef on 23.12.15.
 */
@CucumberOptions(features = "features")
public class MainActivityWithCucumberTestCase extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public MainActivityWithCucumberTestCase() {
        super(MainActivity.class);
    }

    @Given("^I launch the activity$")
    public void launchTheActivityConstructed() {
        activity = getActivity();
    }

    @When("^I press the button$")
    public void shouldClickACucumberButton() {
        onView(ViewMatchers.withId(com.example.marekdef.testcoverage.R.id.button3)).perform(click());
    }
}
