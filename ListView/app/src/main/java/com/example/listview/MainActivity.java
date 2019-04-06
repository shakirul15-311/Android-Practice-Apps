package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] countryNames = getResources().getStringArray(R.array.country_lst);
        listView = findViewById(R.id.listViewId);

        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_view, R.id.textView, countryNames );
        listView.setAdapter(adapter);


    }
}
