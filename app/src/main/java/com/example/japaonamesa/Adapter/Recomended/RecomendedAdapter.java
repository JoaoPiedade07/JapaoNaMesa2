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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Model.Recomended.RecomendedModel;
import com.example.japaonamesa.R;

import java.util.List;

public class RecomendedAdapter extends RecyclerView.Adapter<RecomendedAdapter.RecomendedViewHolder> {

    private List<RecomendedModel> recomendedList;

    Context context;
    



    public RecomendedAdapter(List<RecomendedModel> recomendedList, Context context){
        this.recomendedList = recomendedList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecomendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //favDB = new FavDB(context);
        //create table on first
        //SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        //boolean firstStart = prefs.getBoolean("firstStart", true);
        //if (firstStart) {
           // createTableOnFirstStart();
        //}
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recomended, parent, false);
        return new RecomendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecomendedAdapter.RecomendedViewHolder holder, int position) {
        //final RecomendedModel recomendedModel = recomendedList.get(position);

        //readCursorData(recomendedModel, holder);
        holder.recomendedName.setText(recomendedList.get(position).getName());
        holder.recomendedImage.setImageResource(recomendedList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return recomendedList.size();
    }

    public class RecomendedViewHolder extends RecyclerView.ViewHolder {

        private TextView recomendedName;
        private ImageView recomendedImage;
        private Button favBtn;
        public RecomendedViewHolder(@NonNull View itemView) {
            super(itemView);

            recomendedName = itemView.findViewById(R.id.recomendedName);
            recomendedImage = itemView.findViewById(R.id.recomendedImage);

            favBtn = itemView.findViewById(R.id.favBtn);

            //add to fav btn
            /*favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    RecomendedModel recomendedModel = recomendedList.get(position);

                    if (recomendedModel.getFavStatus().equals("0")) {
                        recomendedModel.setFavStatus("1");
                        favDB.insertIntoTheDatabase(recomendedModel.getName(), recomendedModel.getImage(),
                                recomendedModel.getKey_id(), recomendedModel.getFavStatus());
                        favBtn.setBackgroundResource(R.drawable.red_favorite_vector);
                    } else {
                        recomendedModel.setFavStatus("0");
                        favDB.remove_fav(recomendedModel.getKey_id());
                        favBtn.setBackgroundResource(R.drawable.favourite_food_vector);
                    }
                }
            });*/

        }
    }

    /*private void createTableOnFirstStart() {
        favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }*/
    /*private void readCursorData(RecomendedModel recomendedModel, RecomendedAdapter.RecomendedViewHolder viewHolder) {
        Cursor cursor = favDB.read_all_data(recomendedModel.getKey_id());
        SQLiteDatabase database = favDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                String item_fav_status = cursor.getString(cursor.getColumnIndex(FavDB.FAVORITE_STATUS));
                recomendedModel.setFavStatus(item_fav_status);

                //check fav status
                if (item_fav_status != null && item_fav_status.equals("1")) {
                    viewHolder.favBtn.setBackgroundResource(R.drawable.red_favorite_vector);
                } else if (item_fav_status != null && item_fav_status.equals("0")) {
                    viewHolder.favBtn.setBackgroundResource(R.drawable.favourite_food_vector);
                }
            }
        } finally {
            if (cursor != null)
                cursor.close();
            database.close();
        }*/

}
