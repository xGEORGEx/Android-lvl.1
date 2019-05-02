package ru.geekbrains.fragmentnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainFragment extends Fragment {

    private String shape;   // здесь будем хранить название изображения

    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

        shape = getString(R.string.ball);
        final ImageView imageView = fragmentView.findViewById(R.id.imageView);

        RadioButton radioBall = fragmentView.findViewById(R.id.radioBall);
        radioBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // показываем шар, если он выбран
                imageView.setImageResource(R.drawable.ball);
                shape = getString(R.string.ball);
            }
        });

        RadioButton radioStar = fragmentView.findViewById(R.id.radioStar);
        radioStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // показываем звезду, если она выбрана
                imageView.setImageResource(R.drawable.star);
                shape = getString(R.string.star);
            }
        });

        Button button = fragmentView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) { // переход на второй фрагмент
                MainNavigator mainNavigator = (MainNavigator) getActivity();
                mainNavigator.startFragment(shape, secondFragment);
            }
        });

        //Добавляем на фрагмент вторую кнопку и обрабатываем её нажатие
        Button button2 = fragmentView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainNavigator mainNavigator = (MainNavigator) getActivity();
                mainNavigator.startFragment(shape, thirdFragment);
            }
        });

        return fragmentView;
    }
}
