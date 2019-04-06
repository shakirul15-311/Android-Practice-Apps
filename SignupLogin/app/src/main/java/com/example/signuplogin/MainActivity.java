package com.example.signuplogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    //-----
    private EditText phone_nmbr,user_name;
    private AutoCompleteTextView usr_bloodgrp;
    private RadioButton gender_female,gender_male, gender_others;
    private CheckBox agreement_accept;
    private Button usr_signup_btn;

    private String[] bloodGroupList = {"A+","A-","AB+","AB-","B+","B-","O+","O-"};


    //---------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------
        phone_nmbr = findViewById(R.id.usr_phone_nmbr);
        user_name = findViewById(R.id.user_name);
        usr_bloodgrp = findViewById(R.id.usr_bloodgroup);
        gender_male = findViewById(R.id.gender_male);
        gender_female = findViewById(R.id.gender_female);
        gender_others = findViewById(R.id.gender_others);
        agreement_accept = findViewById(R.id.agreement_accept);
        usr_signup_btn = findViewById(R.id.usr_signup_btn);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bloodGroupList);
        usr_bloodgrp.setAdapter(arrayAdapter);
        usr_bloodgrp.setThreshold(1);

        agreement_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean Checked) {
                if(Checked==true){
                    usr_signup_btn.setVisibility(View.VISIBLE);
                }else if(Checked==false){
                    usr_signup_btn.setVisibility(View.GONE);
                }

            }
        });
        //----------

    }
}
