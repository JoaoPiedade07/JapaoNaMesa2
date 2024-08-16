package com.example.japaonamesa.Adapter.Category.Ramen;

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

import com.example.japaonamesa.Adapter.Category.Sushi.SushiAdapter;
import com.example.japaonamesa.Adapter.Fav.FavDB;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.Ramen.RamenModel;
import com.example.japaonamesa.Model.Category.Sushi.SushiModel;
import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Sushi.NigirisScreen;
import com.example.japaonamesa.Recepies.Sushi.SashimiScreen;

import java.util.List;


public class RamenAdapter extends RecyclerView.Adapter<RamenAdapter.RamenViewHolder> {

    private List<RamenModel> ramenList;
    Context context;
    private FavDB favDB;

    public RamenAdapter(List<RamenModel> ramenList, Context context) {
        this.ramenList = ramenList;
        this.context = context;
    }

    @NonNull
    @Override
    public RamenAdapter.RamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new FavDB(context);
        //create table on first
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart) {
            createTableOnFirstStart();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new RamenAdapter.RamenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RamenViewHolder holder, int position) {
        final RamenModel ramenModel = ramenList.get(position);

        readCursorData(ramenModel, holder);
        holder.ramenName.setText(ramenList.get(position).getRamenName());
        holder.ramenImage.setImageResource(ramenList.get(position).getRamenImage());

    }


    @Override
    public int getItemCount() { return ramenList.size();
    }

    public class RamenViewHolder extends RecyclerView.ViewHolder {
        private TextView ramenName;
        private ImageView ramenImage;
        private Button favBtnRamen;
        public RamenViewHolder(@NonNull View itemView) {
            super(itemView);

            ramenName = itemView.findViewById(R.id.recomendedName);
            ramenImage = itemView.findViewById(R.id.recomendedImage);

            favBtnRamen = itemView.findViewById(R.id.favBtn);

            //add to fav btn
            favBtnRamen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    RamenModel ramenModel = ramenList.get(position);

                    if (ramenModel.getFavStatus().equals("0")) {
                        ramenModel.setFavStatus("1");
                        favDB.insertIntoTheDatabase(ramenModel.getRamenName(), ramenModel.getRamenImage(),
                                ramenModel.getKey_id(), ramenModel.getFavStatus());
                        favBtnRamen.setBackgroundResource(R.drawable.red_favorite_vector);
                    } else {
                        ramenModel.setFavStatus("0");
                        favDB.remove_fav(ramenModel.getKey_id());
                        favBtnRamen.setBackgroundResource(R.drawable.favourite_food_vector);
                    }
                }
            });

        }
    }

    private void createTableOnFirstStart() {
        favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
    private void readCursorData(RamenModel ramenModel, RamenAdapter.RamenViewHolder viewHolder) {
        Cursor cursor = favDB.read_all_data(ramenModel.getKey_id());
        SQLiteDatabase database = favDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                ramenModel.setFavStatus(item_fav_status);

                //check fav status
                if (item_fav_status != null && item_fav_status.equals("1")) {
                    viewHolder.favBtnRamen.setBackgroundResource(R.drawable.red_favorite_vector);
                } else if (item_fav_status != null && item_fav_status.equals("0")) {
                    viewHolder.favBtnRamen.setBackgroundResource(R.drawable.favourite_food_vector);
                }
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            database.close();
        }
    }
}
