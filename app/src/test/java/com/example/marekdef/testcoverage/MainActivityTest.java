package com.example.marekdef.testcoverage;

import android.app.Activity;
import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by marekdef on 24.12.15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    @Test
    public void testClick() {
        Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();

        Button button1 = (Button) activity.findViewById(R.id.button1);
        button1.performClick();
    }
}