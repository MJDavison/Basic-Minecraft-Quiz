package com.example.android.basicminecraftquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonActivity extends AppCompatActivity {
    HeaderFragment header = MainActivity.header;
    RadioButton radioButtonOptionA, radioButtonOptionB, radioButtonOptionC;

    TextView questionNumberTextView, scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);


        questionNumberTextView = findViewById(R.id.textView_questionNumber);
        scoreTextView = findViewById(R.id.textView_score);


        radioButtonOptionA = findViewById(R.id.rdiOne);
        radioButtonOptionB = findViewById(R.id.rdiTwo);
        radioButtonOptionC = findViewById(R.id.rdiThree);

        updateHeader();
    }

    void updateHeader() {
        scoreTextView.setText(getString(R.string.score, header.getPoints()));
        questionNumberTextView.setText(getString(R.string.question_number, header.getQuestionNumber()));
    }


    public void submitRadioButtonAnswer(View view) {
        if (radioButtonOptionB.isChecked()) {
            header.setPoints(header.getPoints() + 1);
        }
        header.setQuestionNumber(header.getQuestionNumber() + 1);
        Intent intentText = new Intent(RadioButtonActivity.this, TextBoxActivity.class);
        startActivity(intentText);
    }
}