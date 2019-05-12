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

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class WeatherActivity extends AppCompatActivity implements FragmentNavigation {

    private WeatherFragment weatherFragment;
    private HistoryFragment historyFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherFragment = new WeatherFragment();
        historyFragment = new HistoryFragment();


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, weatherFragment);
        fragmentTransaction.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if (weatherFragment != null){
            weatherFragment.setWeather(intent.getStringExtra("City"),
                    intent.getBooleanExtra("Wind", false),
                    intent.getBooleanExtra("Pressure", false),
                    intent.getBooleanExtra("Humidity", false));
        }
    }


    @Override
    public void startFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // добавить фрагмент
        fragmentTransaction.replace(R.id.fragment_container, historyFragment);

        // закрыть транзакцию
        fragmentTransaction.commit();


    }
}
