package app.geekbrains.myweather;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    private static final String CITY = "City";
    private static final String WIND = "Wind";
    private static final String PRESSURE = "Pressure";
    private static final String HUMIDITY = "Humidity";
    private EditText city;
    private CheckBox wind;
    private CheckBox pressure;
    private CheckBox humidity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.editCity);
        wind = findViewById(R.id.checkWind);
        pressure = findViewById(R.id.checkPressure);
        humidity = findViewById(R.id.checkHumidity);
        Button getWeather = findViewById(R.id.buttonWeather);

        //Если устройство перевернули в альбомную ориентацию, активити создается в первый раз,
        //и введено название города то передаем в фрагмент сохраненные параметры
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE
               && savedInstanceState != null && savedInstanceState.containsKey(CITY)){
           createFragment(savedInstanceState.getString(CITY), savedInstanceState.getBoolean(WIND),
                   savedInstanceState.getBoolean(PRESSURE),savedInstanceState.getBoolean(HUMIDITY));
        }


        getWeather.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Если поле пустое выводим сообщение о необходимости ввести название города
                if (city.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), R.string.warrning_message,
                            Toast.LENGTH_SHORT).show();
                } else {
                    //Если устройство перевернули в альбомную ориентацию, то передаем параметы в фрагмет
                    if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){
                        createFragment(city.getText().toString(), wind.isChecked(),
                                pressure.isChecked(), humidity.isChecked());
                    //Иначе вызываем вторую активити и передаем параметры ей
                    } else {
                        Intent intent = new Intent(v.getContext(), WeatherActivity.class);
                        intent.putExtra(CITY, city.getText().toString());
                        intent.putExtra(WIND, wind.isChecked());
                        intent.putExtra(PRESSURE, pressure.isChecked());
                        intent.putExtra(HUMIDITY, humidity.isChecked());
                        startActivity(intent);
                    }
                }
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        //Если название города введено то сохраняем текущие параметры
        if (!city.getText().toString().isEmpty()){
            savedInstanceState.putString(CITY, city.getText().toString());
            savedInstanceState.putBoolean(WIND, wind.isChecked());
            savedInstanceState.putBoolean(PRESSURE, pressure.isChecked());
            savedInstanceState.putBoolean(HUMIDITY, humidity.isChecked());
            Log.d(TAG, "1");
            super.onSaveInstanceState(savedInstanceState);
        }
    }

    //В этом методе с помощью FragmentManager вызываем метод врагмента setWeather
    //и передаем в него параметры
    private void createFragment (String city, boolean wind, boolean pressure, boolean humidity){
        FragmentManager fragmentManager = getSupportFragmentManager();
        WeatherFragment weatherFragment = (WeatherFragment)
                fragmentManager.findFragmentById(R.id.weather_fragment);
        if (weatherFragment != null) {
            weatherFragment.setWeather(city, wind, pressure, humidity);
        }
    }
}
