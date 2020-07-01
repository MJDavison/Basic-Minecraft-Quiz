package com.example.android.basicminecraftquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckBoxActivity extends AppCompatActivity {
    HeaderFragment header = MainActivity.header;

    TextView questionNumberTextView, scoreTextView;

    CheckBox checkboxA, checkboxB, checkboxC, checkboxD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        checkboxA = findViewById(R.id.checkboxOne);
        checkboxB = findViewById(R.id.checkboxTwo);
        checkboxC = findViewById(R.id.checkboxThree);
        checkboxD = findViewById(R.id.checkboxFour);

        questionNumberTextView = findViewById(R.id.textView_questionNumber);
        scoreTextView = findViewById(R.id.textView_score);

        updateHeader();


    }

    void updateHeader() {
        scoreTextView.setText(getString(R.string.score, header.getPoints()));
        questionNumberTextView.setText(getString(R.string.question_number, header.getQuestionNumber()));
    }


    public void submitCheckboxAnswer(View view) {
        if (checkboxB.isChecked() && checkboxC.isChecked() && checkboxD.isChecked() && !checkboxA.isChecked())
            header.setPoints(header.getPoints() + 1);
        header.setQuestionNumber(header.getQuestionNumber() + 1);
        Intent intentRadio = new Intent(CheckBoxActivity.this, RadioButtonActivity.class);
        startActivity(intentRadio);


    }
}