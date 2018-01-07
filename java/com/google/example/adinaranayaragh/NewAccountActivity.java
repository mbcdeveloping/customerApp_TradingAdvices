package com.google.example.adinaranayaragh;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class NewAccountActivity extends AppCompatActivity {
    private EditText newEmail;
    private EditText newPassword;
    private EditText retypeNewPasword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        newEmail = findViewById(R.id.NewImail_Inp);
        newPassword = findViewById(R.id.NewPassword_Inp);
        retypeNewPasword = findViewById(R.id.retype_password_inp);
        mAuth = FirebaseAuth.getInstance();
    }
    public void logInActiv(View v){
        Intent i = new Intent(NewAccountActivity.this, LogInActivity.class);
        startActivity(i);
    }

    public void register(View v){
        String email = newEmail.getText().toString();
        String password = newPassword.getText().toString();
        String retype_password = retypeNewPasword.getText().toString();

        if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password) || TextUtils.isEmpty(retype_password)){
            ///we check to see if the fields are empty
            Toast.makeText(NewAccountActivity.this,"One ore more fields are empty!",Toast.LENGTH_LONG).show();//displays the message to the user

        }else if (password.equals(retype_password)){

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Intent i = new Intent(NewAccountActivity.this,LogInActivity.class);
                                startActivity(i);

                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(NewAccountActivity.this, "Account creation failed./the password to short.../try again",
                                        Toast.LENGTH_LONG).show();

                            }

                            // ...
                        }
                    });



        }else {
            Toast.makeText(NewAccountActivity.this,"Passwords don't match!", Toast.LENGTH_LONG).show();

        }


    }
}
