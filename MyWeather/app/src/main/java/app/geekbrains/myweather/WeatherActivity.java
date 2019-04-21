package app.geekbrains.myweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        TextView city = findViewById(R.id.textCity);
        final TextView wind = findViewById(R.id.textWind);
        final TextView pressure = findViewById(R.id.textPressure);
        final TextView humidity = findViewById(R.id.textHumidity);

        Intent intent = getIntent();
        city.setText(intent.getStringExtra("City"));
        //Если доп параметры в главном Activity были выбраны, то делаем
        // компоненты видимыми и загружаем в них информацию
        if (intent.getBooleanExtra("Wind", false)){
            wind.setText(R.string.wind);
            wind.setVisibility(View.VISIBLE);
        }
        if (intent.getBooleanExtra("Pressure", false)){
            pressure.setText(R.string.pressure);
            pressure.setVisibility(View.VISIBLE);
        }
        if (intent.getBooleanExtra("Humidity", false)){
            humidity.setText(R.string.humidity);
            humidity.setVisibility(View.VISIBLE);
        }

    }

}
