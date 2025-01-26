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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.japaonamesa.HomeScreen.HomeScreen;

import com.example.japaonamesa.R;
import com.example.japaonamesa.WelcomeScreen;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignInScreen extends AppCompatActivity {
    Button signInButtom;
    EditText editEmail, editPassword;
    ImageView googleBtn, goToWelcomeScreen;
    FirebaseAuth firebaseAuth, mAuth;
    FirebaseDatabase firebaseDatabase;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    int RC_SIGN_IN = 20;

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
        setContentView(R.layout.sign_in_screen);

        googleBtn = findViewById(R.id.GoogleBtn);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        gsc = GoogleSignIn.getClient(SignInScreen.this,gso);

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        editEmail = findViewById(R.id.Email);
        editPassword = findViewById(R.id.Password);
        mAuth = FirebaseAuth.getInstance();
        signInButtom = findViewById(R.id.SignInButton);
        goToWelcomeScreen = findViewById(R.id.backSignIn);

        goToWelcomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
                startActivity(intent);
                finish();
            }
        });


        signInButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exibe a barra de progresso

                // Obtém o email e senha inseridos pelo usuário
                String email, password;
                 email = String.valueOf(editEmail.getText());
                 password = String.valueOf(editPassword.getText());

                // Verifica se o email ou senha estão vazios
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(SignInScreen.this, "Please enter an email and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Cria uma nova conta de usuário no Firebase
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Esconde a barra de progresso após a conclusão

                                if (task.isSuccessful()) {
                                    // Se o registro for bem-sucedido, envia o e-mail de verificação
                                    sendEmailVerification();
                                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Se houver falha no registro, exibe uma mensagem de erro
                                    Toast.makeText(SignInScreen.this, "Fail to create account",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }

    private void sendEmailVerification() {
        mAuth.getCurrentUser().sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // Exibe uma mensagem se o e-mail de verificação for enviado com sucesso
                            Toast.makeText(SignInScreen.this, "Verificação de email enviada.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // Exibe uma mensagem se houver falha no envio do e-mail de verificação
                            Toast.makeText(SignInScreen.this, "Falha ao enviar email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void signIn(){

        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuth(account.getIdToken());

            }catch (Exception e){

                Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void firebaseAuth(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("id", user.getUid());
                            map.put("name", user.getDisplayName());
                            map.put("profile", user.getPhotoUrl().toString());
                            firebaseDatabase.getReference().child("users").child(user.getUid()).setValue(map);
                            Intent intent = new Intent(SignInScreen.this, HomeScreen.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(SignInScreen.this, "Something went wrong", Toast.LENGTH_SHORT);
                        }
                    }
                });
    }
}