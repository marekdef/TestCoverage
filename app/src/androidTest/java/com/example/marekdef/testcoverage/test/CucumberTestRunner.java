package com.example.marekdef.testcoverage.test;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import android.util.Log;

import com.example.marekdef.testcoverage.BuildConfig;

import cucumber.api.android.CucumberInstrumentationCore;

/**
 * Created by marekdef on 23.12.15.
 */
public class CucumberTestRunner extends AndroidJUnitRunner {
    private static final String TAG = "CucumberTestRunner";
    private CucumberInstrumentationCore instrumentation;
    private Bundle results = new Bundle();
    private boolean finishedOnce = false;

    public CucumberTestRunner() {
        instrumentation = new CucumberInstrumentationCore(this);
    }

    @Override
    public void onCreate(final Bundle arguments) {
        for(String key: arguments.keySet()) {
            Log.d(TAG, key + "=" + String.valueOf(arguments.get(key)));
        }

        instrumentation.create(arguments);
        super.onCreate(arguments);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentation.start();
        waitForIdleSync();
        super.onStart();
    }

    @Override
    public void finish(final int resultCode, final Bundle results) {
        Log.i(TAG, "Finishing with resultCode = " + resultCode);

        this.results.putAll(results);

        if(this.finishedOnce)
            super.finish(resultCode, this.results);
        else
            finishedOnce = true;
    }

    static  {
        System.setProperty("jacoco-agent.destfile", "/data/data/" + BuildConfig.APPLICATION_ID + "/coverage.ec");
    }
}
