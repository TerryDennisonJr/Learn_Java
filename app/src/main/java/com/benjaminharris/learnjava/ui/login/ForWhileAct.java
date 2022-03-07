package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.benjaminharris.learnjava.R;

public class ForWhileAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_while);
    }

    public void forWhileWebView(View v) {
        Intent intent = new Intent(this, ForWhileWebView.class);
        startActivity(intent);
    }

    public void forWhileQuiz(View v) {
        Intent intent = new Intent(this, ForWhileQuiz.class);
        startActivity(intent);

    }
}
