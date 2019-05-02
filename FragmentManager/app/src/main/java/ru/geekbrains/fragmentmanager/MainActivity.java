package ru.geekbrains.fragmentmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создадим фрагменты
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // обработка кнопок
        Button add1 = findViewById(R.id.add1);
        add1.setOnClickListener(new ListenerOnAdd(fragment1));

        Button add2 = findViewById(R.id.add2);
        add2.setOnClickListener(new ListenerOnAdd(fragment2));

        Button add3 = findViewById(R.id.add3);
        add3.setOnClickListener(new ListenerOnAdd(fragment3));

        Button remove1 = findViewById(R.id.remove1);
        remove1.setOnClickListener(new ListenerOnRemove(fragment1));

        Button remove2 = findViewById(R.id.remove2);
        remove2.setOnClickListener(new ListenerOnRemove(fragment2));

        Button remove3 = findViewById(R.id.remove3);
        remove3.setOnClickListener(new ListenerOnRemove(fragment3));

        Button replace1 = findViewById(R.id.replace1);
        replace1.setOnClickListener(new ListenerOnReplace(fragment1));

        Button replace2 = findViewById(R.id.replace2);
        replace2.setOnClickListener(new ListenerOnReplace(fragment2));

        Button replace3 = findViewById(R.id.replace3);
        replace3.setOnClickListener(new ListenerOnReplace(fragment3));

        // Обработка кнопки "Назад"
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }

    // при написании анонимного класса-обработчика для кнопки было замечено, что при этом возникает
    // много дублирующегося кода - поэтому было решено перенести этот код в отдельный класс
    // сравните с:
    // add1.setOnClickListener(new View.OnClickListener(){
    //    @Override
    //    public void onClick(View v) {
    //        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    //        fragmentTransaction.add(R.id.fragment_container, fragment);
    //        fragmentTransaction.commit();
    //    }
    //  });
    private class ListenerOnAdd implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnAdd(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            addFragment();
        }

        // Добавить фрагмент
        private void addFragment() {
            // открыть транзакцию
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //перед добавление врагмента удаляем предыдущий
            fragmentTransaction.remove(fragment);
            // добавить фрагмент
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack("");
            // закрыть транзакцию
            fragmentTransaction.commit();
        }
    }

    private class ListenerOnRemove implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnRemove(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            removeFragment();
        }

        // удалить фрагмент
        private void removeFragment() {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }

    private class ListenerOnReplace implements View.OnClickListener {

        private final Fragment fragment;

        private ListenerOnReplace(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View view) {
            replaceFragment();
        }

        // заменить фрагмент
        private void replaceFragment() {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
        }
    }
}
