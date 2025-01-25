package com.example.japaonamesa.Adapter.Category.Sushi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.Sushi.SushiModel;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Sushi.NigirisScreen;
import com.example.japaonamesa.Recepies.Sushi.SashimiScreen;

import java.util.List;

public class SushiAdapter extends RecyclerView.Adapter<SushiAdapter.SushiViewHolder> {
    private List<SushiModel> sushiList;
    Context context;
    //private FavDB favDB;

    public SushiAdapter(List<SushiModel> sushiList, Context context) {
        this.sushiList = sushiList;
        this.context = context;
    }

    @NonNull
    @Override
    public SushiAdapter.SushiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //favDB = new FavDB(context);
        //create table on first
        //SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        //boolean firstStart = prefs.getBoolean("firstStart", true);
        //if (firstStart) {
        // createTableOnFirstStart();
        //}
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new SushiAdapter.SushiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SushiAdapter.SushiViewHolder holder, int position) {
        //final SushiModel sushiModel = sushiList.get(position);

        //readCursorData(sushiModel, holder);
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
                    case " Salmon Sashimi":
                        intent = new Intent(context, SashimiScreen.class);
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
        return sushiList.size();
    }

    public class SushiViewHolder extends RecyclerView.ViewHolder {

        private TextView sushiName;
        private ImageView sushiImage, favBtnSushi;

        public SushiViewHolder(@NonNull View itemView) {
            super(itemView);

            sushiName = itemView.findViewById(R.id.recomendedName);
            sushiImage = itemView.findViewById(R.id.recomendedImage);

            favBtnSushi = itemView.findViewById(R.id.favBtn);
        }
    }
}
