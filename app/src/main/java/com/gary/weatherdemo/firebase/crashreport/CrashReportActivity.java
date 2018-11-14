package com.gary.weatherdemo.firebase.crashreport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gary.weatherdemo.R;

public class CrashReportActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_crash_report);

        /*// Log the onCreate event, this will also be printed in logcat
        Crashlytics.log(Log.VERBOSE, TAG, "onCreate");

        // Add some custom values and identifiers to be included in crash reports
        Crashlytics.setInt("MeaningOfLife", 42);
        Crashlytics.setString("LastUIAction", "Test value");
        Crashlytics.setUserIdentifier("123456789");

        // Report a non-fatal exception, for demonstration purposes
        Crashlytics.logException(new Exception("Non-fatal exception: something went wrong!"));

        // Checkbox to indicate when to catch the thrown exception.
        final CheckBox catchCrashCheckBox = findViewById(R.id.catchCrashCheckBox);

        // Button that causes NullPointerException to be thrown.
        Button crashButton = findViewById(R.id.crashButton);
        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log that crash button was clicked.
                Crashlytics.log(Log.INFO, TAG, "Crash button clicked.");

                // If catchCrashCheckBox is checked catch the exception and report is using
                // logException(), Otherwise throw the exception and let Crashlytics automatically
                // report the crash.
                if (catchCrashCheckBox.isChecked()) {
                    try {
                        throw new NullPointerException();
                    } catch (NullPointerException ex) {
                        // [START crashlytics_log_and_report]
                        Crashlytics.log(Log.ERROR, TAG, "NPE caught!");
                        Crashlytics.logException(ex);
                        // [END crashlytics_log_and_report]
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        });

        // Log that the Activity was created.
        // [START crashlytics_log_event]
        Crashlytics.log("Activity created");
        // [END crashlytics_log_event]*/
    }
}

