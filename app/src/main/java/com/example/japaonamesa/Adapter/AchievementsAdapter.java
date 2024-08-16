package com.example.japaonamesa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.Model.AchievementsModel;
import com.example.japaonamesa.R;

import java.util.List;

public class AchievementsAdapter extends RecyclerView.Adapter<AchievementsAdapter.AchievementsViewHolder> {
    private List<AchievementsModel> achievementsList;

    public AchievementsAdapter(List<AchievementsModel> achievementsList){
        this.achievementsList = achievementsList;
    }
    @NonNull
    @Override
    public AchievementsAdapter.AchievementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category, parent, false);
        return new AchievementsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementsAdapter.AchievementsViewHolder holder, int position) {
        holder.nameAchievements.setText(achievementsList.get(position).getAchievementsName());
        holder.imageAchievements.setImageResource(achievementsList.get(position).getAchievementsImage());
    }

    @Override
    public int getItemCount() {
        return achievementsList.size();
    }

    public class AchievementsViewHolder extends RecyclerView.ViewHolder {
        private TextView nameAchievements ;
        private ImageView imageAchievements ;
        public AchievementsViewHolder(@NonNull View itemView) {
            super(itemView);

            nameAchievements = itemView.findViewById(R.id.categoryName);
            imageAchievements  = itemView.findViewById(R.id.categoryImage);
        }
    }
}
