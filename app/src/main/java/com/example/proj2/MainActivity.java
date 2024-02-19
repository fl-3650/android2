package com.example.proj2;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Camera mCamera;

    static final String STATE_SCORE = "pS";
    static final String STATE_LEVEL = "pL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTextView = findViewById(R.id.hello);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Debug.stopMethodTracing();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mCamera != null) {
            // mCamera.release();
            mCamera = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mCamera == null) {
            initializeCamera();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        ContentValues values = new ContentValues();
        // ...
    }

    @Override
    protected void onStart() {
        super.onStart();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (!gpsEnabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private void initializeCamera() {
    }

    private void setUpActionBar() {
        ActionBar actionBar = getActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onSavedInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_SCORE, 5);
        savedInstanceState.putInt(STATE_LEVEL, 5);

        super.onSaveInstanceState(savedInstanceState);
    }
}