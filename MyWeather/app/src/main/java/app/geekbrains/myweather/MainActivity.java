package app.geekbrains.myweather;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class MainActivity extends AppCompatActivity{

    private List<City> citySource;

    private static final String CITY = "City";
    private static final String WIND = "Wind";
    private static final String PRESSURE = "Pressure";
    private static final String HUMIDITY = "Humidity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_city);
        // установим аниматор по умолчанию
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // эта установка служит для повышения производительности системы.
        recyclerView.setHasFixedSize(true);

        // создаем источник данных
        final CitySourseBulder builder = new CitySourseBulder(getResources());
        citySource = builder.build();

        // будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final CityAdapter cityAdapter = new CityAdapter(citySource);
        recyclerView.setAdapter(cityAdapter);

        cityAdapter.setOnItemClickListener(new CityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(view.getContext(), WeatherActivity.class);
                        intent.putExtra(CITY, citySource.get(position).getCity());
                        intent.putExtra(WIND, citySource.get(position).isWind());
                        intent.putExtra(PRESSURE, citySource.get(position).isPressure());
                        intent.putExtra(HUMIDITY, citySource.get(position).isHumidity());
                        startActivity(intent);
            }
        });
    }





}
