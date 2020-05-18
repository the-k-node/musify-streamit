package com.example.musicplayerproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;

public class StartScreenActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
   private ProgressBar progressBar;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();

//    FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
//            .setTimestampsInSnapshotsEnabled(true)
//            .build();
//    db.setFirestoreSettings(settings);

    private static final String Key_mail="mail";
    private static final String Key_name="name";
    private static final String Key_mobile="mobile";
    private static final String Key_password="password";

    private static final String key_pplink="PPLink1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        mAuth = FirebaseAuth.getInstance();


    }

    public void signinBottomSheetDialog(View v){
        Toast.makeText(getApplicationContext(),"Signin",Toast.LENGTH_LONG).show();
        final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(StartScreenActivity.this,R.style.BottomSheetTheme);
        bottomSheetDialog1.setContentView(R.layout.activity_signin);
        bottomSheetDialog1.findViewById(R.id.signin_sibtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextInputLayout mEmail, mPass;
                mEmail = (TextInputLayout) bottomSheetDialog1.findViewById(R.id.signin_email_et);
                mPass = (TextInputLayout)bottomSheetDialog1.findViewById(R.id.signin_pwd_et);

                progressBar=bottomSheetDialog1.findViewById(R.id.progressbar);

                final String email = mEmail.getEditText().getText().toString();
                final String pass = mPass.getEditText().getText().toString();
                if(email.isEmpty() || pass.isEmpty()){
                    //include required conditions
                    if(email.isEmpty()){
                        mEmail.setError("email required");
                    }
                    if(pass.isEmpty()){
                        mPass.setError("password required");
                    }
                }
               else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    mEmail.setError("Valid email required");
                }

                else if (pass.length()<6)
                {
                    mPass.setError("minimum length 6");
                }
                else {
                    mEmail.setErrorEnabled(false);
                    mPass.setErrorEnabled(false);
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful())
                            {
                                progressBar.setVisibility(View.GONE);
                                // String mailget=getIntent().getStringExtra("mail");

                                Toast.makeText(getApplicationContext(), "Signed In: " + email + "\n" + pass, Toast.LENGTH_SHORT).show();
                               // startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                intent.putExtra("mail",email);
                                startActivity(intent);
                                //finish();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
        bottomSheetDialog1.show();
    }

    public void signupBottomSheetDialog(View v){
        Toast.makeText(getApplicationContext(),"SignUp",Toast.LENGTH_LONG).show();
        final BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(StartScreenActivity.this, R.style.BottomSheetTheme);
        bottomSheetDialog2.setContentView(R.layout.activity_signup);
        bottomSheetDialog2.findViewById(R.id.signup_sibtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout mSignUpName, mSignUpEmail, mSignUpPass, mSignUpContact;
                mSignUpName = bottomSheetDialog2.findViewById(R.id.signup_name_et);
                mSignUpEmail = bottomSheetDialog2.findViewById(R.id.signup_email_et);
                mSignUpPass = bottomSheetDialog2.findViewById(R.id.signup_pwd_et);
                mSignUpContact = bottomSheetDialog2.findViewById(R.id.signup_ph_et);

                progressBar=bottomSheetDialog2.findViewById(R.id.progressbar);

                final String namet = mSignUpName.getEditText().getText().toString();
                final String emailt = mSignUpEmail.getEditText().getText().toString();
                final String passt = mSignUpPass.getEditText().getText().toString();
                final String pht = mSignUpContact.getEditText().getText().toString();

                if(namet.isEmpty() || emailt.isEmpty() || passt.isEmpty() || pht.isEmpty() ){
                    if(namet.isEmpty()){
                        //include required conditions
                        mSignUpName.setError("name required");
                    }
                    if(emailt.isEmpty()){
                        mSignUpEmail.setError("email required");
                    }
                    if(passt.isEmpty()){
                        mSignUpPass.setError("password required");
                    }
                    if(pht.isEmpty()){
                        mSignUpContact.setError("contact required");
                    }

                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(emailt).matches())
                {
                    mSignUpEmail.setError("Valid email required");
                }

                else if (passt.length()<6)
                {
                    mSignUpPass.setError("Minimum length is 6");
                }
                else if (namet.isEmpty())
                {
                    mSignUpName.setError("Name is required");
                }

                else if (pht.length() <10)
                {
                    mSignUpContact.setError("Enetr a 10 digit mNumber");
                }

                else {
                    mSignUpName.setErrorEnabled(false);
                    mSignUpContact.setErrorEnabled(false);
                    mSignUpEmail.setErrorEnabled(false);
                    mSignUpPass.setErrorEnabled(false);

                    progressBar.setVisibility(View.VISIBLE);

                    mAuth.createUserWithEmailAndPassword(emailt,passt)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);

                                    if (task.isSuccessful())
                                    {

                                        Map<String, Object> note=new HashMap<>();
                                        note.put(Key_mail,emailt);
                                        note.put(Key_password,passt);
                                        note.put(Key_name,namet);
                                        note.put(Key_mobile,pht);

                                        note.put(key_pplink," ");

                                        db.collection(emailt).document("UserData").set(note)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toast.makeText(getApplicationContext(),"::",Toast.LENGTH_SHORT).show();
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getApplicationContext(),"Cant create database",Toast.LENGTH_SHORT).show();

                                                    }
                                                });

                                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                        intent.putExtra("mail",emailt);
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(),"User registered sucessfully.",Toast.LENGTH_SHORT).show();
                                       // finish();

                                    }
                                    else {
                                        if (task.getException() instanceof FirebaseAuthUserCollisionException)
                                        {
                                            Toast.makeText(getApplicationContext(),"User already exist.",Toast.LENGTH_SHORT).show();

                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                }
                            });



                 }
            }
        });
        bottomSheetDialog2.show();
    }

    public void forgotPassBottomSheetDialog(View v){
        Toast.makeText(getApplicationContext(),"Forgot Password",Toast.LENGTH_LONG).show();
        final BottomSheetDialog bottomSheetDialog3 = new BottomSheetDialog(StartScreenActivity.this,R.style.BottomSheetTheme);
        bottomSheetDialog3.setContentView(R.layout.activity_forgot_password);
        bottomSheetDialog3.findViewById(R.id.forgotp_confirm_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextInputLayout fEmail;
                fEmail = (TextInputLayout) bottomSheetDialog3.findViewById(R.id.forgot_email_et);
                final String forgot_email = fEmail.getEditText().getText().toString();
                //include required conditions
                if(forgot_email.isEmpty()){
                    fEmail.setError("email required");
                }
                else {
                    fEmail.setErrorEnabled(false);
                    Toast.makeText(getApplicationContext(),"Check your mail for Verification details",Toast.LENGTH_LONG).show();
                    recreate();
                }
            }
        });
        bottomSheetDialog3.show();
    }

}
