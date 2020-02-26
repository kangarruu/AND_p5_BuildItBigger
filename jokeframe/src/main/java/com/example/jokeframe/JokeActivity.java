package com.example.jokeframe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {
    private static final String JOKE_INTENT_KEY = "joke_key";
    private String mJoke;
    private TextView jokeTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intentFromMain = getIntent();
        if(intentFromMain != null && intentFromMain.hasExtra(JOKE_INTENT_KEY)){
            mJoke = intentFromMain.getStringExtra(JOKE_INTENT_KEY);
        }

        jokeTv = findViewById(R.id.jokeView);
        jokeTv.setText(mJoke);
    }

}
