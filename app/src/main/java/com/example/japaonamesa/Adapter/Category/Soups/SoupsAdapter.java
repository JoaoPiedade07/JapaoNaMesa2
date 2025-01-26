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

import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.Soups.SoupsModel;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Soups.MisoSoupScreen;

import java.util.List;

public class SoupsAdapter extends RecyclerView.Adapter<SoupsAdapter.SoupsViewHolder> {
    private List<SoupsModel> soupsList;
    Context context;

    public SoupsAdapter(List<SoupsModel> soupsList, Context context) {
        this.soupsList = soupsList;
        this.context = context;
    }

    @NonNull
    @Override
    public SoupsAdapter.SoupsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new SoupsAdapter.SoupsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoupsAdapter.SoupsViewHolder holder, int position) {
        //final SushiModel sushiModel = sushiList.get(position);

        //readCursorData(sushiModel, holder);
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
    }

    @Override
    public int getItemCount() {
        return soupsList.size();
    }

    public class SoupsViewHolder extends RecyclerView.ViewHolder {

        private TextView soupName;
        private ImageView soupImage, favBtnSushi;

        public SoupsViewHolder(@NonNull View itemView) {
            super(itemView);

            soupName = itemView.findViewById(R.id.recomendedName);
            soupImage = itemView.findViewById(R.id.recomendedImage);

            favBtnSushi = itemView.findViewById(R.id.favBtn);
        }
    }
}
