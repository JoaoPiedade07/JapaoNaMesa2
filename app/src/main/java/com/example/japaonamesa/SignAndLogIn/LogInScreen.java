package com.example.japaonamesa.SignAndLogIn;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.japaonamesa.HomeScreen.HomeScreen;
import com.example.japaonamesa.R;
import com.example.japaonamesa.WelcomeScreen;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInScreen extends AppCompatActivity {

    EditText editEmail, editPassword;
    ImageView goToWelcomeScreen, googleBtn;
    Button logInButtom;
    FirebaseAuth mAuth;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    int RC_LOG_IN = 20;

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_screen);

        googleBtn = findViewById(R.id.GoogleBtn);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        gsc = GoogleSignIn.getClient(LogInScreen.this,gso);

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { logIn();
            }
        });

        editEmail = findViewById(R.id.LogEmail);
        editPassword = findViewById(R.id.LogPassword);
        logInButtom = findViewById(R.id.LogInButton);
        mAuth = FirebaseAuth.getInstance();

        goToWelcomeScreen = findViewById(R.id.backLogIn);

        goToWelcomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        logInButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Obtém o email e senha inseridos pelo usuário
                String email, password;
                email = String.valueOf(editEmail.getText());
                password = String.valueOf(editPassword.getText());

                // Verifica se o email ou senha estão vazios
                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(LogInScreen.this, "Please, introduce the email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LogInScreen.this, "Please, introduce thepassword", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Efetua o login do usuário no Firebase
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Se o login for bem-sucedido, abre a tela principal
                                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Se houver falha no login, exibe uma mensagem de erro
                                    Toast.makeText(LogInScreen.this, "Fail to login, please check your email or password",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
    private void logIn(){

        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,RC_LOG_IN);
    }

}