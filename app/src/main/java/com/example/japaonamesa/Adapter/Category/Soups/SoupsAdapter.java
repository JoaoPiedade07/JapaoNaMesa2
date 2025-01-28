package com.example.japaonamesa.Adapter.Category.Soups;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.Soups.SoupsModel;
import com.example.japaonamesa.Model.Category.Sushi.SushiModel;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Soups.MisoSoupScreen;

import java.util.List;

public class SoupsAdapter extends RecyclerView.Adapter<SoupsAdapter.SoupsViewHolder> {
    private List<SoupsModel> soupsList;
    Context context;
    private FavDB favDB;

    public SoupsAdapter(List<SoupsModel> soupsList, Context context) {
        this.soupsList = soupsList;
        this.context = context;
        favDB = new FavDB(context);
    }

    @NonNull
    @Override
    public SoupsAdapter.SoupsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new SoupsAdapter.SoupsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoupsAdapter.SoupsViewHolder holder, int position) {
        SoupsModel item = soupsList.get(position);

        holder.soupName.setText(soupsList.get(position).getSoupName());
        holder.soupImage.setImageResource(soupsList.get(position).getSoupImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                String itemName = soupsList.get(position).getSoupName();

                switch (itemName) {
                    case "Miso Soup":
                        intent = new Intent(context, MisoSoupScreen.class);
                        break;

                    default:
                        intent = new Intent(context, HomeScreen.class);
                        break;
                }
                context.startActivity(intent);
            }
        });

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
                favDB.addFavorite(item.getKey_id(), item.getSoupName(), String.valueOf(item.getSoupImage()));
                item.setFavStatus(1); // Atualiza o status para favorito
                holder.favBtn.setImageResource(R.drawable.favourite_food_vector_red);
            }
        });
    }

    @Override
    public int getItemCount() {
        return soupsList.size();
    }

    public class SoupsViewHolder extends RecyclerView.ViewHolder {

        private TextView soupName;
        private ImageView soupImage, favBtn;

        public SoupsViewHolder(@NonNull View itemView) {
            super(itemView);

            soupName = itemView.findViewById(R.id.recomendedName);
            soupImage = itemView.findViewById(R.id.recomendedImage);

            favBtn = itemView.findViewById(R.id.favBtn);
        }
    }
}
