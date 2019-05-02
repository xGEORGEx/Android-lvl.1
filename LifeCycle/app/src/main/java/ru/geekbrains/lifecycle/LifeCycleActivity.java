package ru.geekbrains.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Toast.makeText(getApplicationContext(), "Активити onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onCreate активити");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Активити onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onStart активити");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Активити onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onResume активити");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Активити onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onPause активити");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Активити onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onStop активити");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Активити onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onRestart активити");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Активити onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onDestroy активити");
    }
}
