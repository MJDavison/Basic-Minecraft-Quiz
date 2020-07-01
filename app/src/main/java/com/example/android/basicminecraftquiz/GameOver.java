package com.example.android.basicminecraftquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {
    HeaderFragment header = MainActivity.header;

    Button tryAgainButton;
    TextView finalScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        finalScoreTextView = findViewById(R.id.textView_finalScore);
        tryAgainButton = findViewById(R.id.btn_scoreTryAgain);
        if (header.getPoints() == 4)
            tryAgainButton.setText(R.string.retryBestScore);
        else if (header.getPoints() < 1)
            finalScoreTextView.setText(getString(R.string.finalScore0, header.getPoints()));
        else
            finalScoreTextView.setText(getString(R.string.finalscore1, header.getPoints()));

        Toast.makeText(getApplicationContext(), "You got " + header.getPoints() + "/4!", Toast.LENGTH_SHORT).show();
    }

    public void clickedTryAgain(View view) {
        Intent restartIntent = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        if (restartIntent != null) {
            restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        header.setPoints(0);
        header.setQuestionNumber(0);
        startActivity(restartIntent);

    }


}