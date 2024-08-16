package com.example.japaonamesa.Adapter.Category;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.CategoryScreen.Gyosas.GyosasCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Ramen.RamenCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Rolls.RollsCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Soba.SobaCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Soups.SoupsCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Sushi.SushiCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Udon.UdonCategoryScreen;
import com.example.japaonamesa.FavouriteScreen.FavouriteScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.CategoryScreenModel;
import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;

import java.util.List;

public class CategoryScreenAdapter extends RecyclerView.Adapter<CategoryScreenAdapter.CategoryScreenViewHolder> {
    private List<CategoryScreenModel> categoryScreenList;
    Context context;

    public CategoryScreenAdapter(List<CategoryScreenModel> categoryScreenList, Context context){
        this.categoryScreenList = categoryScreenList;
        this.context = context;

    }
    @NonNull
    @Override
    public CategoryScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category_screen, parent, false);
        return new CategoryScreenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryScreenViewHolder holder, int position) {
        holder.NameCategory.setText(categoryScreenList.get(position).getCategoryname());
        holder.ImageCategory.setImageResource(categoryScreenList.get(position).getCategoryimage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                String itemName = categoryScreenList.get(position).getCategoryname();

                switch (itemName) {
                    case "Sushi":
                        intent = new Intent(context, SushiCategoryScreen.class);
                        break;
                    case "Ramen":
                        intent = new Intent(context, RamenCategoryScreen.class);
                        break;

                    case "Rolls":
                        intent = new Intent(context, RollsCategoryScreen.class);
                        break;

                    case "Gyosas":
                        intent = new Intent(context, GyosasCategoryScreen.class);
                        break;

                    case "Udon":
                        intent = new Intent(context, UdonCategoryScreen.class);
                        break;

                    case "Soups":
                        intent = new Intent(context, SoupsCategoryScreen.class);
                        break;

                    case "Soba":
                        intent = new Intent(context, SobaCategoryScreen.class);
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
        return categoryScreenList.size();
    }

    public class CategoryScreenViewHolder extends RecyclerView.ViewHolder {
        TextView NameCategory;
        ImageView ImageCategory;
        public CategoryScreenViewHolder(@NonNull View itemView) {
            super(itemView);

            NameCategory = itemView.findViewById(R.id.categoryScreenTxt);
            ImageCategory = itemView.findViewById(R.id.categoryScreenImage);
        }
    }
}
