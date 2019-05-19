package com.example.otpsigninbyfacebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        Button btnSignout = (Button) findViewById(R.id.btnLogout);
        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountKit.logOut();
                finish();
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(Account account) {
                EditText edtUserId, edtPhone,edtEmail;

                edtUserId= (EditText)findViewById(R.id.edtUserId);
                edtUserId.setText(String.format("User Id %s",account.getId()));



                edtUserId= (EditText)findViewById(R.id.edtUserEmail);
                edtUserId.setText(String.format("Email %s",account.getEmail()));


                edtUserId= (EditText)findViewById(R.id.edtUserPhone);
                edtUserId.setText(String.format("Phone %s",account.getPhoneNumber() == null ? "" :account.getPhoneNumber().toString()));
            }

            @Override
            public void onError(AccountKitError accountKitError) {

            }
        });
    }
}
