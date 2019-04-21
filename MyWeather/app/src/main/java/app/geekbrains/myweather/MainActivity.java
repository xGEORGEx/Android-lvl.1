package app.geekbrains.myweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getWeather = findViewById(R.id.buttonWeather);
        final EditText city = findViewById(R.id.editCity);
        final CheckBox wind = findViewById(R.id.checkWind);
        final CheckBox pressure = findViewById(R.id.checkPressure);
        final CheckBox humidity = findViewById(R.id.checkHumidity);

        getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Если поле пустое выводим сообщение о необходимости ввести название города
                if (city.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), R.string.warrning_message,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    intent.putExtra("City", city.getText().toString());
                    intent.putExtra("Wind", wind.isChecked());
                    intent.putExtra("Pressure", pressure.isChecked());
                    intent.putExtra("Humidity", humidity.isChecked());
                    startActivity(intent);
                }
            }
        });
    }
}
