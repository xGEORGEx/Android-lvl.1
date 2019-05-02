package ru.geekbrains.fragmentnavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainNavigator {

    private MainFragment   mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment   = new MainFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // добавить фрагмент
        fragmentTransaction.add(R.id.fragment_container, mainFragment);
        // закрыть транзакцию
        fragmentTransaction.commit();
    }

    @Override
    public void startFragment(String shape, SecondFragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(mainFragment);

        // добавить фрагмент
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack("");

        // закрыть транзакцию
        fragmentTransaction.commit();

        fragment.setShape(shape);
    }
}
