package app.geekbrains.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WeatherFragment extends Fragment{


    private TextView cityView;
    private TextView temperatureView;
    private TextView weatherView;
    private TextView windView;
    private TextView pressureView;
    private TextView humidityView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.weather_fragment, container, false);
        cityView = layout.findViewById(R.id.textCity);
        temperatureView = layout.findViewById(R.id.textTemperature);
        weatherView = layout.findViewById(R.id.textWeather);
        windView = layout.findViewById(R.id.textWind);
        pressureView = layout.findViewById(R.id.textPressure);
        humidityView = layout.findViewById(R.id.textHumidity);

        Button historyBtn = layout.findViewById(R.id.btnHistory);
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentNavigation fragmentNavigation = (FragmentNavigation) getActivity();
                fragmentNavigation.startFragment();
            }
        });

        return layout;
    }



    //В этом методе устанавливаем текст элементам фрагмента, в зависимости от передаваемых параметров
    public void setWeather (String city, boolean wind, boolean pressure, boolean humidity){
        cityView.setText(city);
        temperatureView.setText(R.string.temperature);
        weatherView.setText(R.string.weather);
        if (wind){
            windView.setText(R.string.wind);
            windView.setVisibility(View.VISIBLE);
        } else {
            windView.setVisibility(View.GONE);
        }
        if (pressure){
            pressureView.setText(R.string.pressure);
            pressureView.setVisibility(View.VISIBLE);
        } else {
            pressureView.setVisibility(View.GONE);
        }
        if (humidity){
            humidityView.setText(R.string.humidity);
            humidityView.setVisibility(View.VISIBLE);
        } else {
            humidityView.setVisibility(View.GONE);
        }
    }

}

