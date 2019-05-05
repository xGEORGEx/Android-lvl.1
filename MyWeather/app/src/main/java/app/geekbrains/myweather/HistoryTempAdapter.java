package app.geekbrains.myweather;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HistoryTempAdapter extends RecyclerView.Adapter<HistoryTempAdapter.ViewHolder> {

    private final List<HistoryTemp> historySource;

    public class ViewHolder extends  RecyclerView.ViewHolder{

        private final TextView data;
        private final TextView temperature;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            data = itemView.findViewById(R.id.data);
            temperature = itemView.findViewById(R.id.temperature);

        }
    }

    public HistoryTempAdapter (List<HistoryTemp> historySource){
        this.historySource = historySource;
    }

    @NonNull
    @Override
    public HistoryTempAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.history_temp, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        HistoryTemp item = historySource.get(position);

        viewHolder.data.setText(item.getData());
        viewHolder.temperature.setText(item.getTemperatura());
    }

    @Override
    public int getItemCount() {
        return historySource.size();
    }


}
