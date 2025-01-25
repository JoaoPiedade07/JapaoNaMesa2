package com.example.japaonamesa.Adapter.Recomended;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.R;

import java.util.List;

public class RecomendedAdapter extends RecyclerView.Adapter<RecomendedAdapter.RecomendedViewHolder> {

    private List<RecomendedModel> recomendedModels;
    Context context;
    private FavDB favDB;

    public RecomendedAdapter(List<RecomendedModel> recomendedModels, Context context){
        this.recomendedModels = recomendedModels;
        this.context = context;
        favDB = new FavDB(context); // Instancia o banco de dados
    }
    @NonNull
    @Override
    public RecomendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new RecomendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecomendedAdapter.RecomendedViewHolder holder, int position) {
        RecomendedModel item = recomendedModels.get(position);

        holder.recomendedName.setText(item.getName());
        holder.recomendedImage.setImageResource(item.getImage());

        // Verifica se o item está favoritado e altera o ícone do favorito
        if (item.getFavStatus() == 1) {
            holder.favBtn.setImageResource(R.drawable.favourite_food_vector_red); // Ícone quando favorito
        } else {
            holder.favBtn.setImageResource(R.drawable.favourite_food_vector); // Ícone quando não favorito
        }

        // Ao clicar no ícone de favorito, muda o status de favorito
        holder.favBtn.setOnClickListener(v -> {
            if (item.getFavStatus() == 1) {
                favDB.removeFavorite(item.getKey_id());
                item.setFavStatus(0); // Atualiza o status para não favorito
                holder.favBtn.setImageResource(R.drawable.favourite_food_vector);
            } else {
                favDB.addFavorite(item.getKey_id(), item.getName(), String.valueOf(item.getImage()));
                item.setFavStatus(1); // Atualiza o status para favorito
                holder.favBtn.setImageResource(R.drawable.favourite_food_vector_red);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recomendedModels.size();
    }

    public class RecomendedViewHolder extends RecyclerView.ViewHolder {

        private TextView recomendedName;
        private ImageView recomendedImage;
        private ImageView favBtn;

        public RecomendedViewHolder(@NonNull View itemView) {
            super(itemView);

            recomendedName = itemView.findViewById(R.id.recomendedName);
            recomendedImage = itemView.findViewById(R.id.recomendedImage);

            favBtn = itemView.findViewById(R.id.favBtn);
        }
    }
}
