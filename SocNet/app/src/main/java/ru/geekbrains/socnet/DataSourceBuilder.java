package ru.geekbrains.socnet;

import android.content.res.Resources;
import android.content.res.TypedArray;
import java.util.ArrayList;
import java.util.List;

// построитель источника данных
public class DataSourceBuilder {

    private final List<Soc> dataSource;   // строим этот источник данных
    private final Resources resources;    // ресурсы приложения

    public DataSourceBuilder(Resources resources) {
        dataSource = new ArrayList<>(6);
        this.resources = resources;
    }

    // создаем данные
    public List<Soc> build() {
        // строки описаний из ресурсов
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        // изображения
        int[] pictures = getImageArray();
        // заполнение источника данных
        for (int i = 0; i < descriptions.length; i++)
            dataSource.add(new Soc(descriptions[i], pictures[i], false));
        return dataSource;
    }

    // Механизм вытаскивания идентификаторов картинок (к сожеланию просто массив не работает)
    // https://stackoverflow.com/questions/5347107/creating-integer-array-of-resource-ids
    private int[] getImageArray() {
        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);
        int length = pictures.length();
        int[] answer = new int[length];

        for (int i = 0; i < length; i++)
            answer[i] = pictures.getResourceId(i, 0);

        pictures.recycle();

        return answer;
    }
}
