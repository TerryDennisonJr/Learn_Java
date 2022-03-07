package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.benjaminharris.learnjava.R;


public class IfElseAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_if_else);
    }

    public void IfElseWebView(View v) {
        Intent intent = new Intent(this, IfElseWebView.class);
        startActivity(intent);
    }

    public void IfElseQzBtn(View v) {
        Intent intent = new Intent(this, IfElseQuiz.class);
        startActivity(intent);

    }
}
