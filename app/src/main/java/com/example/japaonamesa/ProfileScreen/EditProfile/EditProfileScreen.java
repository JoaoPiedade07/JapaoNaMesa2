package com.example.japaonamesa.ProfileScreen.EditProfile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.ProfileScreen.ProfileScreen;
import com.example.japaonamesa.R;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class EditProfileScreen extends AppCompatActivity {

    ImageView backProfileBtn,editProfileImg;

    TextView editProfileImage, editName, editUsername, editDescription, doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_screen);

        //Back to Profile Screen
        backProfileBtn = findViewById(R.id.BackProfileBtn);

        backProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //Edit Profile Image
        editProfileImg = findViewById(R.id.ProfileImage);
        editProfileImage = findViewById(R.id.EditProfileImage);


        editProfileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(EditProfileScreen.this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080,1080)
                        .start();

            }
        });

        //Edit Name, Username and Description
        editName = findViewById(R.id.txtName);
        editUsername = findViewById(R.id.txtUsername);
        editDescription = findViewById(R.id.txtDescription);

        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditNameScreen.class);
                startActivity(intent);
                finish();
            }
        });

        editUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditUsernameScreen.class);
                startActivity(intent);
                finish();
            }
        });

        editDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditDescScreen.class);
                startActivity(intent);
                finish();
            }
        });

        //salvar a imagem na database
        doneBtn = findViewById(R.id.doneBtnEditProfile);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        editProfileImg.setImageURI(uri);
    }
}