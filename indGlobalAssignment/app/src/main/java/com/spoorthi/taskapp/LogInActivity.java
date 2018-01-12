package com.spoorthi.taskapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spoorthi.taskapp.Model.LogInPresenterImpl;
import com.spoorthi.taskapp.Presenter.LogInPresenter;
import com.spoorthi.taskapp.View.LogInView;

public class LogInActivity extends AppCompatActivity implements LogInView,View.OnClickListener
{
    private LogInPresenter logInPresenter;
    Button logIn;
    EditText emailorPh,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);

        logIn = (Button)findViewById(R.id.liginBtn);
        emailorPh = (EditText)findViewById(R.id.emailorPh);
        password = (EditText)findViewById(R.id.password);
        logIn.setOnClickListener(this);
    }


    @Override
    public void showValidationError()
    {
        showAlert("Log In Validation error");
        Log.e("Validation ","error");
    }

    @Override
    public void logInSuccess()
    {
        Log.e("LogIn ","success");
        Intent i = new Intent(LogInActivity.this,HomeActivity.class);
        startActivity(i);
    }

    @Override
    public void logInError()
    {
        showAlert("Log In error");
        Log.e("LogIn ","error");
    }

    @Override
    public void onClick(View view)
    {
        if(view == logIn)
        {
            hideKeyboard(LogInActivity.this);
            logInPresenter = new LogInPresenterImpl(LogInActivity.this,LogInActivity.this);
            logInPresenter.logIn(emailorPh.getText().toString(),password.getText().toString());
        }
    }

    public static void hideKeyboard(Activity activity) {
        View v = activity.getWindow().getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    private void showAlert(String message)
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(LogInActivity.this);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
