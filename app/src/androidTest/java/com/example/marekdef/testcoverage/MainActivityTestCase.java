package com.example.marekdef.testcoverage;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MainActivityTestCase extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTestCase() {
        super(MainActivity.class);
    }

    public void testInstrumentation() {
        MainActivity activity = getActivity();
        final Button button2 = (Button) activity.findViewById(R.id.button2);

        button2.post(new Runnable() {
            @Override
            public void run() {
                button2.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();
    }
}