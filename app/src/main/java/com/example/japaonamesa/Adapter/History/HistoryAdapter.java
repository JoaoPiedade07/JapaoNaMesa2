package com.example.japaonamesa.Adapter.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.Model.History.HistoryModel;
import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    private List<HistoryModel> historyModels;
    Context context;
    private FavDB favDB;

    public HistoryAdapter(List<HistoryModel> historyModels, Context context){
        this.historyModels = historyModels;
        this.context = context;
        favDB = new FavDB(context); // Instancia o banco de dados
    }
    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_history, parent, false);
        return new HistoryAdapter.HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        HistoryModel item = historyModels.get(position);

        holder.historyName.setText(item.getName());
        holder.historyImage.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() { return historyModels.size(); }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        private TextView historyName;
        private ImageView historyImage;
        private ImageView favBtn;

        public HistoryViewHolder(View itemView) {
            super(itemView);

            historyName = itemView.findViewById(R.id.recomendedName);
            historyImage = itemView.findViewById(R.id.recomendedImage);

            favBtn = itemView.findViewById(R.id.favBtn);
        }
    }
}
