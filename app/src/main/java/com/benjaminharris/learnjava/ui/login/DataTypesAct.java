package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.benjaminharris.learnjava.R;

public class DataTypesAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_types);
    }

    public void DataTypeWebView(View v) {
        Intent intent = new Intent(this, DataTypeWebView.class);
        startActivity(intent);
    }

    public void DataTypeQuiz(View v) {
        Intent intent = new Intent(this, DataTypeQuiz.class);
        startActivity(intent);

    }
}
