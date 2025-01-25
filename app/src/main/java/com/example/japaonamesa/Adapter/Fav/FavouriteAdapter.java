package com.example.japaonamesa.Adapter.Fav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.FavouriteScreen.FavDB.FavDB;
import com.example.japaonamesa.FavouriteScreen.FavDB.FavItem;
import com.example.japaonamesa.R;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {

    private Context context;
    private List<FavItem> favouriteItems;
    private FavDB favDB;

    public FavouriteAdapter(Context context, List<FavItem> favouriteItems) {
        this.context = context;
        this.favouriteItems = favouriteItems;

        // Inicializa o banco de dados de favoritos
        favDB = new FavDB(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_favourite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FavItem item = favouriteItems.get(position);

        // Define os dados do item
        holder.title.setText(item.getTitle());
        holder.image.setImageResource(item.getImage());

        // Remove o item dos favoritos ao clicar no botão de remover
        holder.removeButton.setOnClickListener(v -> {
            // Remove o item do banco de dados
            favDB.removeFavorite(item.getId());

            // Remove o item da lista local e notifica o adaptador
            favouriteItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, favouriteItems.size());
        });
    }

    @Override
    public int getItemCount() {
        return favouriteItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        ImageView removeButton; // Botão para remover o item dos favoritos

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializa os componentes do layout
            title = itemView.findViewById(R.id.favoriteName);
            image = itemView.findViewById(R.id.favoriteImage);
            removeButton = itemView.findViewById(R.id.RemovefavBtn);
        }
    }
}
