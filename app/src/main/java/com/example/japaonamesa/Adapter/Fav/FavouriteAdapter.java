package com.example.japaonamesa.Adapter.Fav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.FavouriteScreen.FavDB.FavItem;
import com.example.japaonamesa.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {

    private List<FavItem> favouriteModels;
    private Context context;

    private FavDB favDB;

    public FavouriteAdapter(ArrayList<FavItem> favouriteModels, Context context) {
        this.favouriteModels = favouriteModels;
        this.context = context;

    }

    @NonNull
    @Override
    public FavouriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_favourite, parent, false);
        favDB = new FavDB(context);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull FavouriteAdapter.ViewHolder holder, int position) {
        holder.categoryName.setText(favouriteModels.get(position).getItemTitle());
        holder.categoryImage.setImageResource(favouriteModels.get(position).getItem_image());
    }

    @Override
    public int getItemCount() {
        return favouriteModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView  categoryImage;
        TextView categoryName;
        Button favBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.favoriteImage);
            categoryName = itemView.findViewById(R.id.favoriteName);
            favBtn = itemView.findViewById(R.id.RemovefavBtn);

            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   int position = getAdapterPosition();
                   final FavItem favItem = favouriteModels.get(position);
                   favDB.remove_fav(favItem.getKey_id());
                   removeItem(position);
                }
            });

        }
    }

    private void removeItem(int position) {
        favouriteModels.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, favouriteModels.size());
    }

}
