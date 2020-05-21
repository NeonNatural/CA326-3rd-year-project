package ie.bim.myapplication.ui.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.nio.charset.Charset;

import androidx.appcompat.app.AppCompatActivity;
import ie.bim.myapplication.R;
import ie.bim.myapplication.data.ServiceGenerator;
import ie.bim.myapplication.data.TweetApi;
import ie.bim.myapplication.ui.HomeActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class LoginActivity extends AppCompatActivity {

    private final String AUTH_TOKEN = "N1CD8Okgbnkxct2uLwKOMH7UF:uAB5GnzvdHivsLyQ1UBo3qHuXMhd7zIMFFndFLX4AHf51RrQOF";

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private FirebaseAuth mAuth;
    private TweetApi tweetApi;

    private SharedPreferences.Editor sharedPrefEditor;

    private EditText emailInput;
    private EditText passwordInput;

    private Button loginBtn;
    private Button registerBtn;
    private TextView resetPasswordButton;

    private ProgressBar loginBtnProgress;
    private static final int MY_PERMISSIONS_REQUEST =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        tweetApi = ServiceGenerator.createService(TweetApi.class);

        sharedPrefEditor = getSharedPreferences("com.test", MODE_PRIVATE).edit();



        emailInput = findViewById(R.id.resetPassEmail);
        passwordInput = findViewById(R.id.login_password);

        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.forgotPassButton);

        loginBtnProgress = findViewById(R.id.loginBtnProgress);
        resetPasswordButton = findViewById(R.id.forgotPass);

        byte[] authTokenData = AUTH_TOKEN.getBytes(Charset.forName("UTF-8"));

        String base64AuthToken = "Basic " + Base64.encodeToString(authTokenData, Base64.NO_WRAP);

        login(base64AuthToken);
        registerBtn.setOnClickListener(view -> {
            Intent registerActivity = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(registerActivity);
        });

        loginBtn.setOnClickListener(view -> {
            final String mail = emailInput.getText().toString();
            final String password = passwordInput.getText().toString();


            if (mail.isEmpty() || password.isEmpty()) {
                showMessage("Please Verify All Field");
            } else {
                loginBtn.setVisibility(View.INVISIBLE);
                loginBtnProgress.setVisibility(View.VISIBLE);

                signIn(mail, password);
            }
        });

        resetPasswordButton.setOnClickListener(view -> {
            Intent resetactivity = new Intent(getApplicationContext(), ResetPassActivity.class);
            startActivity(resetactivity);
        });



    }

    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    private void login(String authToken) {
        compositeDisposable.add(tweetApi.getToken(authToken, "client_credentials")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (bearerToken) -> {
                            sharedPrefEditor.putString("bearer", bearerToken.tokenType + " " + bearerToken.accessToken).commit();
                        },
                        (error) -> {
                            Toast.makeText(this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                ));
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            updateUI();
        }

    }

    private void signIn(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        sharedPrefEditor.putString("email", mail).commit();
                        updateUI();
                    } else {
                        loginBtnProgress.setVisibility(View.INVISIBLE);
                        loginBtn.setVisibility(View.VISIBLE);
                        showMessage(task.getException().getMessage());
                    }
                });
    }

    private void updateUI() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

}
