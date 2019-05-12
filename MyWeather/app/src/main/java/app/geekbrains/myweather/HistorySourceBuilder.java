package app.geekbrains.myweather;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class HistorySourceBuilder {

    private final List<HistoryTemp> historySource;
    private final Resources resources;

    public HistorySourceBuilder(Resources resources) {
        historySource = new ArrayList<>(10);
        this.resources = resources;
    }

    // создаем данные
    public List<HistoryTemp> build() {
        String[] data = resources.getStringArray(R.array.data);
        String[] temperatura = resources.getStringArray(R.array.temperatura);
        for (int i = 0; i < data.length; i++)
            historySource.add(new HistoryTemp(data[i], temperatura[i]));
        return historySource;
    }
}
