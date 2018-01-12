package com.spoorthi.taskapp.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.spoorthi.taskapp.BaseUrls;
import com.spoorthi.taskapp.Presenter.LogInPresenter;
import com.spoorthi.taskapp.R;
import com.spoorthi.taskapp.View.LogInView;
import com.spoorthi.taskapp.apiCalls.PostForLogIn;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Spoorthi on 1/11/2018.
 */

public class LogInPresenterImpl implements LogInPresenter
{

    private LogInView logInView;
    Context context;
    ProgressDialog progressDialog;

    String useremail, password;

    public LogInPresenterImpl(LogInView logInView, Context context) {
        this.logInView = logInView;
        this.context = context;
    }

    @Override
    public void logIn(String userName, String passWord)
    {
        useremail = userName;
        password = passWord;
        if(TextUtils.isEmpty(userName) || (TextUtils.isEmpty(passWord)))
        {
            logInView.showValidationError();
        }
        else
        {
            if (!isNetworkConnected()) {//No Internet
                Toast.makeText(context, "Network error",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                callgetProjectApi(datajson(userName, passWord));
            }
        }

    }

    private String datajson(String userName, String passWord)
    {
        JSONObject obj = new JSONObject();
        try {
            obj.put("email", ""+userName);
            obj.put("password", ""+passWord);
            Log.e("obj",""+obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj.toString();
    }



    private void callgetProjectApi(String data)
    {
        progressDialog = new ProgressDialog(context);
        if (progressDialog != null) {
            progressDialog.setMessage("Loading");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        new PostForLogIn()
        {
            @Override
            public void onPostExecute(String result)
            {
                if (result!=null && result!= "null")
                {
                    logInView.logInSuccess();
                    Log.d("result",""+result);
                }
                else if(result == "null")
                {
                        logInView.logInError();
                }

                if (progressDialog.isShowing() && progressDialog != null) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }

        }.execute(BaseUrls.URL,data);

    }

    //Checking for internet availability
    private boolean isNetworkConnected()
    {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}
