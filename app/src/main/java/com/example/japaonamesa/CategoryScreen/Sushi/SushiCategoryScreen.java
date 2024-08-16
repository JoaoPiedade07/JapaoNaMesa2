package com.example.japaonamesa.CategoryScreen.Sushi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.japaonamesa.Adapter.Category.Sushi.SushiAdapter;
import com.example.japaonamesa.CategoryScreen.CategoryScreen;
import com.example.japaonamesa.Model.Category.Sushi.SushiModel;
import com.example.japaonamesa.R;
import java.util.ArrayList;

public class SushiCategoryScreen extends AppCompatActivity {
    ImageView backToCategory;
    private ArrayList<SushiModel> sushiModels = new ArrayList<>();
    private RecyclerView CategorySushiScreenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sushi_category_screen);

        backToCategory = findViewById(R.id.backToCategory);

        backToCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CategoryScreen.class);
                startActivity(intent);
                finish();
            }
        });

        CategorySushiScreenList = findViewById(R.id.CategorySushiScreenList);
        CategorySushiScreenList.setHasFixedSize(true);
        CategorySushiScreenList.setLayoutManager(new GridLayoutManager(this, 2));


        sushiModels.add(new SushiModel(R.drawable.nigiripng, "Salmon Nigiri", "0", "0"));
        sushiModels.add(new SushiModel(R.drawable.sashimipng, "Salmon Sashimi", "1", "0"));
        sushiModels.add(new SushiModel(R.drawable.californiarollpng, "California Roll", "2", "0"));
        sushiModels.add(new SushiModel(R.drawable.tempurarollpng, "Tempura Roll", "3", "0"));
        sushiModels.add(new SushiModel(R.drawable.spicytunarollpng, "Spicy Tuna Roll", "4", "0"));
        sushiModels.add(new SushiModel(R.drawable.ebinigiripng, "Ebi Nigiri", "5", "0"));
        sushiModels.add(new SushiModel(R.drawable.unaginigiripng, "Unagi Nigiri", "6", "0"));
        sushiModels.add(new SushiModel(R.drawable.tunasahimipng, "Tuna Sashimi", "7", "0"));

        SushiAdapter sushiAdapter = new SushiAdapter(sushiModels, this);

        CategorySushiScreenList.setAdapter(sushiAdapter);


    }
}