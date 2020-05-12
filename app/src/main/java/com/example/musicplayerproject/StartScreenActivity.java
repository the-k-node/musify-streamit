package com.example.musicplayerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

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
                else {
                    mEmail.setErrorEnabled(false);
                    mPass.setErrorEnabled(false);
                    Toast.makeText(getApplicationContext(), "Signed In: " + email + "\n" + pass, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
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

                String namet = mSignUpName.getEditText().getText().toString();
                String emailt = mSignUpEmail.getEditText().getText().toString();
                String passt = mSignUpPass.getEditText().getText().toString();
                String pht = mSignUpContact.getEditText().getText().toString();

                if(namet.isEmpty() || emailt.isEmpty() || passt.isEmpty() || pht.isEmpty() || pht.length()!=10){
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
                    if(pht.length()!=10){
                        mSignUpContact.setError("enter valid 10 digit contact number");
                    }
                }
                else {
                    mSignUpName.setErrorEnabled(false);
                    mSignUpContact.setErrorEnabled(false);
                    mSignUpEmail.setErrorEnabled(false);
                    mSignUpPass.setErrorEnabled(false);
                    Toast.makeText(getApplicationContext(), "Signed Up " + namet + emailt + passt + pht, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
