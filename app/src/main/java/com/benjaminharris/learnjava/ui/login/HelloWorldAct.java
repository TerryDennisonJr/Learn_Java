package com.benjaminharris.learnjava.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.benjaminharris.learnjava.HelloWorldWebView;
import com.benjaminharris.learnjava.R;


public class HelloWorldAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

    }

    public void viewHelloWorld(View v) {
        Intent intent = new Intent(this, HelloWorldWebView.class);
        startActivity(intent);
    }
}

