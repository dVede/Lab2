package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.LOG) Log.d(BuildConfig.LOG_TAG, getClass().getSimpleName() + ".onDestroy");
    }

    public void onButtonClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button:
                Intent intent1 = new Intent(this, Floating.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, ContinueWatch.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, KeyboardAvailability.class);
                startActivity(intent3);
                break;
            case R.id.button5:
                Intent intent4 = new Intent(this, ContinueWatch2.class);
                startActivity(intent4);
                break;
        }
    }
}
