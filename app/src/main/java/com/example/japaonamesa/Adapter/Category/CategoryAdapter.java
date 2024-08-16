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

import com.example.japaonamesa.CategoryScreen.Gyosas.GyosasCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Rolls.RollsCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Soba.SobaCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Soups.SoupsCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Sushi.SushiCategoryScreen;
import com.example.japaonamesa.CategoryScreen.Udon.UdonCategoryScreen;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.Model.Category.CategoryModel;
import com.example.japaonamesa.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<CategoryModel> categoryList;

    Context context;

    public CategoryAdapter(List<CategoryModel> categoryList, Context context){
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.nameCategory.setText(categoryList.get(position).getName());
        holder.imageCategory.setImageResource(categoryList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                String itemName = categoryList.get(position).getName();

                switch (itemName) {
                    case "Sushi":
                        intent = new Intent(context, SushiCategoryScreen.class);
                        break;
                    //case "Ramen":
                       // intent = new Intent(context, RamenCategoryScreen.class);
                       // break;

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
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView nameCategory;
        private ImageView imageCategory;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            nameCategory = itemView.findViewById(R.id.categoryName);
            imageCategory = itemView.findViewById(R.id.categoryImage);
        }
    }
}
