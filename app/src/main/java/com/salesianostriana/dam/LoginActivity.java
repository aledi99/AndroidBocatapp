package com.salesianostriana.dam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.salesianostriana.dam.commons.SharedPreferencesManager;

import java.util.HashMap;
import java.util.Map;

import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://localhost:9000")
            .addConverterFactory(GsonConverterFactory.create());
    public static Retrofit retrofit = builder.build();

    EditText email,password;
    Button btnLogin;
    String clientId ="bocatapp-rule-5",grant_type = "password";
    ImageView logo;

    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    private int RC_SIGN_IN = 1;
    private LottieAnimationView dinamita;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ImageView worldLogo;
    private Button buttonSvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logo = findViewById(R.id.imageView8);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button2);
        signInButton = findViewById(R.id.button3);
        mAuth = FirebaseAuth.getInstance();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);

        Glide.with(LoginActivity.this).load(R.drawable.icono).into(logo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeLoginForm(

                );
            }


        });

        signInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signIn();
            }
        });

    }

    private void executeLoginForm(){
        AppService service = ServiceGenerator.createService(AppService.class, email.getText().toString(), password.getText().toString());
        String authorization = "Basic Ym9jYXRhcHAtcnVsZS01OnNlY3JldA==";

        Call<RespuestaToken> call = service.login(clientId,email.getText().toString(),password.getText().toString(),grant_type,authorization);
        call.enqueue(new Callback<RespuestaToken>() {
            @Override
            public void onResponse(Call<RespuestaToken> call, Response<RespuestaToken> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "logeado correctamente", Toast.LENGTH_SHORT).show();
                    //SharedPreferencesManager.setStringValue("access_token",response.body().getAccess_token());
                    //Log.d("access_token", response.body().getAccess_token());
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }else{
                    Log.d("error_login", String.valueOf(response.body()));
                    Toast.makeText(LoginActivity.this, "Email y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<RespuestaToken> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInresult(task);
        }
    }

    private void handleSignInresult(Task<GoogleSignInAccount> completedTask){
        try{
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            FirebaseGoogleAuth(acc);

        }
        catch(ApiException e){
            Toast.makeText(LoginActivity.this, "El registro no se pudo completar",Toast.LENGTH_SHORT).show();
            //FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Correcto",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                    Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this, "Login Incorrecto",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }

    private void updateUI(final FirebaseUser fUser){
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account != null){
            String name = account.getDisplayName();
            String givenName = account.getGivenName();
            String familyName = account.getFamilyName();
            String email = account.getEmail();
            String id = account.getId();
            Uri foto = account.getPhotoUrl();


            final Map<String, Object> usuario = new HashMap<>();
            usuario.put("name", account.getGivenName());
            usuario.put("surname", account.getFamilyName());
            usuario.put("email", account.getEmail());
            usuario.put("photoUrl", account.getPhotoUrl().toString());

            db.collection("users")
                    .document(fUser.getUid())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                DocumentSnapshot document = task.getResult();
                                if(document.exists()){
                                }else{
                                    db.collection("users")
                                            .document(fUser.getUid())
                                            .set(usuario);
                                }
                            }
                        }
                    });

        }
    }
}
