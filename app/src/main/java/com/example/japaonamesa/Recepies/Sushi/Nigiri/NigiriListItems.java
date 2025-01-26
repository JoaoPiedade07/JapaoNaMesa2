package com.example.japaonamesa.Recepies.Sushi.Nigiri;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;


import com.example.japaonamesa.R;
import com.example.japaonamesa.Recepies.Sushi.NigirisScreen;

public class NigiriListItems extends AppCompatActivity {
    CheckBox checkBoxSushiRice, checkBoxFish, checkBoxWasabi, checkBoxSoySauce, checkBoxNori;
    ViewFlipper viewFlipper; // Adicionando o ViewFlipper

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nigiri_list_items);

        // Inicializar o ViewFlipper
        viewFlipper = findViewById(R.id.viewFlipper);

        checkBoxSushiRice = findViewById(R.id.checkBoxSushiRice);
        checkBoxFish = findViewById(R.id.checkBoxFish);
        checkBoxWasabi = findViewById(R.id.checkBoxWasabi);
        checkBoxSoySauce = findViewById(R.id.checkBoxSoySauce);
        checkBoxNori = findViewById(R.id.checkBoxNori);

        checkBoxSushiRice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxSushiRice.setPaintFlags(checkBoxSushiRice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    checkBoxSushiRice.setPaintFlags(checkBoxSushiRice.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        checkBoxFish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxFish.setPaintFlags(checkBoxFish.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    checkBoxFish.setPaintFlags(checkBoxFish.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        checkBoxWasabi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxWasabi.setPaintFlags(checkBoxWasabi.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    checkBoxWasabi.setPaintFlags(checkBoxWasabi.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        checkBoxSoySauce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxSoySauce.setPaintFlags(checkBoxSoySauce.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    checkBoxSoySauce.setPaintFlags(checkBoxSoySauce.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        checkBoxNori.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBoxNori.setPaintFlags(checkBoxNori.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    checkBoxNori.setPaintFlags(checkBoxNori.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        // Configurando o botão para alternar para a próxima tela no ViewFlipper
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

        ImageView backToNigiriScreen = findViewById(R.id.backToNigiriScreen);

        backToNigiriScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NigirisScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
