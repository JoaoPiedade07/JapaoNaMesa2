package com.example.japaonamesa.Adapter.Category.Sushi;

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
import com.example.japaonamesa.Model.Category.Sushi.SushiModel;
import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Sushi.Nigiri.NigirisScreen;
import com.example.japaonamesa.Recepies.Sushi.Sashimi.SalmonSashimi.SashimiScreen;
import com.example.japaonamesa.Recepies.Sushi.Sashimi.TunaSashimi.TunaSashimiScreen;

import java.util.List;

public class SushiAdapter extends RecyclerView.Adapter<SushiAdapter.SushiViewHolder> {
    private List<SushiModel> sushiList;
    Context context;
    private FavDB favDB;

    public SushiAdapter(List<SushiModel> sushiList, Context context) {
        this.sushiList = sushiList;
        this.context = context;
        favDB = new FavDB(context);
    }

    @NonNull
    @Override
    public SushiAdapter.SushiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new SushiAdapter.SushiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SushiAdapter.SushiViewHolder holder, int position) {
        SushiModel item = sushiList.get(position);

        holder.sushiName.setText(sushiList.get(position).getSushiName());
        holder.sushiImage.setImageResource(sushiList.get(position).getSushiImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                String itemName = sushiList.get(position).getSushiName();

                switch (itemName) {
                    case "Salmon Nigiri":
                        intent = new Intent(context, NigirisScreen.class);
                        break;
                    case "Salmon Sashimi":
                        intent = new Intent(context, SashimiScreen.class);
                        break;
                    case "Tuna Sashimi":
                        intent = new Intent(context, TunaSashimiScreen.class);
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
                favDB.addFavorite(item.getKey_id(), item.getSushiName(), String.valueOf(item.getSushiImage()));
                item.setFavStatus(1); // Atualiza o status para favorito
                holder.favBtn.setImageResource(R.drawable.favourite_food_vector_red);
            }
        });


    }

    @Override
    public int getItemCount() {
        return sushiList.size();
    }

    public class SushiViewHolder extends RecyclerView.ViewHolder {

        private TextView sushiName;
        private ImageView sushiImage, favBtn;

        public SushiViewHolder(@NonNull View itemView) {
            super(itemView);

            sushiName = itemView.findViewById(R.id.recomendedName);
            sushiImage = itemView.findViewById(R.id.recomendedImage);

            favBtn = itemView.findViewById(R.id.favBtn);
        }
    }
}
