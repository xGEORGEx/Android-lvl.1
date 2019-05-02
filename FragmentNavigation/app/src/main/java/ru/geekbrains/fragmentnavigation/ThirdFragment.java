package ru.geekbrains.fragmentnavigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


//Так как для третьего фрагмента потребуется тот же метод и то же поле, что присутствуют у
//класса SecondFragment наследуемся от этого класса
public class ThirdFragment extends SecondFragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_third, container, false);

        ImageView imageShape = fragmentView.findViewById(R.id.imageFragment);

        if (shape.equals(getString(R.string.star))){
            imageShape.setImageResource(R.drawable.star);
        }

        if (shape.equals(getString(R.string.ball))){
            imageShape.setImageResource(R.drawable.ball);
        }

        return fragmentView;
    }
}
