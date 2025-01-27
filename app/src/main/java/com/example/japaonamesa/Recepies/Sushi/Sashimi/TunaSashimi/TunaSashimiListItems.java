package com.example.japaonamesa.Recepies.Sushi.Sashimi.TunaSashimi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Sushi.Nigiri.NigirisScreen;

public class TunaSashimiListItems extends AppCompatActivity {

    ViewFlipper viewFlipper; // Adicionando o ViewFlipper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuna_sashimi_list_items);

        viewFlipper = findViewById(R.id.viewFlipperTS);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext(); // Mostra a próxima tela
            }
        });

        // Configurando o botão para alternar para a tela anterior no ViewFlipper
        Button previousButton = findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious(); // Mostra a tela anterior
            }
        });

        ImageView backToNigiriScreen = findViewById(R.id.backToTSashimiScreen);

        backToNigiriScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TunaSashimiScreen.class);
                startActivity(intent);
                finish();
            }
        });


    }
}