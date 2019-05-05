package app.geekbrains.myweather;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Если устройство перевернули в альбомную ориентацию, то закрываем активити
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){
            finish();
            return;
        }


        //с помощью FragmentManager вызываем метод врагмента setWeather
        //и передаем в него параметры от главной активити
        FragmentManager fragmentManager = getSupportFragmentManager();
        WeatherFragment weatherFragment = (WeatherFragment)
                fragmentManager.findFragmentById(R.id.weather_fragment);
        Intent intent = getIntent();
        Log.d(TAG, intent.getStringExtra("City"));
        if (weatherFragment != null){
            Log.d(TAG, "1");
            weatherFragment.setWeather(intent.getStringExtra("City"),
                                       intent.getBooleanExtra("Wind", false),
                                       intent.getBooleanExtra("Pressure", false),
                                       intent.getBooleanExtra("Humidity", false));
            Log.d(TAG, "2");
        }

    }


}
