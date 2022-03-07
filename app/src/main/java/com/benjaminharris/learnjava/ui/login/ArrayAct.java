package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.benjaminharris.learnjava.R;


public class ArrayAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
    }

    public void ArrayWebView(View v) {
        Intent intent = new Intent(this, ArrayWebView.class);
        startActivity(intent);
    }

    public void ArrayQzBtn(View v) {
        Intent intent = new Intent(this, ArrayQuiz.class);
        startActivity(intent);
    }
}

