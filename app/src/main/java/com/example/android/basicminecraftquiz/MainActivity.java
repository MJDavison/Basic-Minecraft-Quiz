package com.example.android.basicminecraftquiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final HeaderFragment header = new HeaderFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        run();
    }

    public void run() {
        Intent intent = new Intent(MainActivity.this, CheckBoxActivity.class);
        startActivity(intent);
    }
}

