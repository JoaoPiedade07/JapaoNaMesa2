package com.example.japaonamesa.Adapter.Category.Ramen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Adapter.Category.Sushi.SushiAdapter;
import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.Model.Category.Ramen.RamenModel;
import com.example.japaonamesa.Model.Category.Sushi.SushiModel;
import com.example.japaonamesa.R;

import java.util.List;

public class RamenAdapter extends RecyclerView.Adapter<RamenAdapter.RamenViewHolder> {

    private List<RamenModel> ramenList;
    Context context;
    private FavDB favDB;

    public RamenAdapter(List<RamenModel> ramenList, Context context) {
        this.ramenList = ramenList;
        this.context = context;
        favDB = new FavDB(context);
    }

    @NonNull
    @Override
    public RamenAdapter.RamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new RamenAdapter.RamenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RamenAdapter.RamenViewHolder holder, int position) {
        RamenModel item = ramenList.get(position);

        holder.ramenName.setText(ramenList.get(position).getRamenName());
        holder.ramenImage.setImageResource(ramenList.get(position).getRamenImage());

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
                favDB.addFavorite(item.getKey_id(), item.getRamenName(), String.valueOf(item.getRamenImage()));
                item.setFavStatus(1); // Atualiza o status para favorito
                holder.favBtn.setImageResource(R.drawable.favourite_food_vector_red);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class RamenViewHolder extends RecyclerView.ViewHolder {

        private TextView ramenName;
        private ImageView ramenImage, favBtn;

        public RamenViewHolder(@NonNull View itemView) {
            super(itemView);

            ramenName = itemView.findViewById(R.id.recomendedName);
            ramenImage = itemView.findViewById(R.id.recomendedImage);

            favBtn = itemView.findViewById(R.id.favBtn);
        }
    }
}
