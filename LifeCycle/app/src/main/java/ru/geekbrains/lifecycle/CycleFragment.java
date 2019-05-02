package ru.geekbrains.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CycleFragment extends Fragment {

    private static final String TAG = "myLogs";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onAttach()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onAttach фрагмента");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onCreate фрагмента");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент CreateView()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onCreateView фрагмента");
        return inflater.inflate(R.layout.fragment_life, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onActivityCreated()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onActivityCreated фрагмента");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onStart фрагмента");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onResume фрагмента");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onPause фрагмента");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onStop фрагмента");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onDestroyView()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onDestroyView фрагмента");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onDestroy фрагмента");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity().getApplicationContext(),
                "Фрагмент onDetach()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Вызываем onDetach фрагмента");
    }
}
