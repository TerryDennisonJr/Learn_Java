package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.benjaminharris.learnjava.R;

public class SyntaxAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syntax);
    }

    public void syntaxWebView(View v) {
        Intent intent = new Intent(this, SyntaxWebView.class);
        startActivity(intent);
    }

    public void SyntaxQuizBtn(View v) {
        Intent intent = new Intent(this, SyntaxQuiz.class);
        startActivity(intent);

    }
}
