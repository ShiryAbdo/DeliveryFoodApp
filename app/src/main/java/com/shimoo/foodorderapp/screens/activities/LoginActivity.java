package com.shimoo.foodorderapp.screens.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
 import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;


import com.shimoo.foodorderapp.R;
import com.shimoo.foodorderapp.screens.fragments.RegistrationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {


    @BindView(R.id.email)AutoCompleteTextView mEmailView;
    @BindView(R.id.password)EditText mPasswordView;
    @BindView(R.id.email_sign_in_button)Button mEmailSignInButton;
    @BindView(R.id.login_progress)ProgressBar mProgressView;
    @BindView(R.id.cbShowPwd)CheckBox mCbShowPwd;
    @BindView((R.id.SignUp))LinearLayout SignUpLiner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);





        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {



                attemptLogin();
            }

        });
        mCbShowPwd.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    mPasswordView.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    mPasswordView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        SignUpLiner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                 getSupportFragmentManager().beginTransaction().add(R.id.mainLogin, new RegistrationFragment()).addToBackStack(null).commit();


            }
        });

     }


    private void attemptLogin() {
        Intent intent = new Intent(LoginActivity.this,MainHomeActivity.class);
        startActivity(intent);
    }



 }

