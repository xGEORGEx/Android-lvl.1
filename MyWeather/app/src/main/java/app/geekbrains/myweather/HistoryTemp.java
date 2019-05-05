package app.geekbrains.myweather;

public class HistoryTemp {

    private final String data;
    private final String temperatura;

    public HistoryTemp(String data, String temperatura) {
        this.data = data;
        this.temperatura = temperatura;
    }

    public String getData(){
        return this.data;
    }

    public String getTemperatura(){
        return this.temperatura;
    }
}
