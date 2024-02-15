package com.example.proj2;

import android.app.ActionBar;
import android.content.ContentValues;
import android.graphics.Camera;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTextView = findViewById(R.id.hello);

        setUpActionBar();
    }

    @Override
    public void onDestroy() {
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
    public void onResume() {
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

    private void initializeCamera() {
    }

    private void setUpActionBar() {
        ActionBar actionBar = getActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}