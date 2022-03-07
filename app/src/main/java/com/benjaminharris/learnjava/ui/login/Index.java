package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import com.benjaminharris.learnjava.R;


public class Index extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void helloWordBtnClick(View v) {
        Intent intent = new Intent(this, HelloWorldAct.class);
        startActivity(intent);
    }

    public void ifElseBtn(View v) {
        Intent intent = new Intent(this, IfElseAct.class);
        startActivity(intent);
    }

    public void arrayBtn(View v) {
        Intent intent = new Intent(this, ArrayAct.class);
        startActivity(intent);
    }

    public void SyntaxBtn(View v) {
        Intent intent = new Intent(this, SyntaxAct.class);
        startActivity(intent);
    }
    public void dataTypesBtn(View v) {
        Intent intent = new Intent(this, DataTypesAct.class);
        startActivity(intent);
    }

    public void forWhileBtn(View v) {
        Intent intent = new Intent(this, ForWhileAct.class);
        startActivity(intent);
    }
}

