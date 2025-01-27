package com.example.japaonamesa.Adapter.Recomended;

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
import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Gyosas.GyosasScreen;
import com.example.japaonamesa.Recepies.Rolls.SpringRollsScreen;
import com.example.japaonamesa.Recepies.Soups.MisoSoupScreen;
import com.example.japaonamesa.Recepies.Sushi.Nigiri.NigirisScreen;
import com.example.japaonamesa.Recepies.Sushi.Sashimi.TunaSashimi.TunaSashimiScreen;

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                String itemName = recomendedModels.get(position).getName();

                switch (itemName) {
                    case "Spring Rolls":
                        intent = new Intent(context, SpringRollsScreen.class);
                        break;
                    case "Miso Soup":
                        intent = new Intent(context, MisoSoupScreen.class);
                        break;
                    case "Gyosas":
                        intent = new Intent(context, GyosasScreen.class);
                        break;
                    case "Tuna Sashimi":
                        intent = new Intent(context, TunaSashimiScreen.class);
                        break;
                    /*case "Udon":
                        intent = new Intent(context, TunaSashimiScreen.class);
                        break;*/
                    case "Salmon nigiri":
                        intent = new Intent(context, NigirisScreen.class);
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
