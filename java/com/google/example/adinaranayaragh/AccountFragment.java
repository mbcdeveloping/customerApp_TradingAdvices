package com.google.example.adinaranayaragh;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by mihal on 1/4/2018.
 */

public class AccountFragment extends Fragment {
    TextView email;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user=  mAuth.getCurrentUser();
    Button resetPassword ;
    Button logOutButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        View view = inflater.inflate(R.layout.fragment_account_info, container, false);
        email = view.findViewById(R.id.email_display);
        resetPassword=  view.findViewById(R.id.reset_button);
        final String user_email=  user.getEmail();
        email.setText(user_email);
        logOutButton = view.findViewById(R.id.log_out_button);
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.sendPasswordResetEmail(user_email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(getContext(),
                                            "An email was sent to your inbox, please follow the instructions in that email in order to reset your password",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), LogInActivity.class)); //Go back to home page
                getActivity().finish();
            }
        });

        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Account info");
    }
}
