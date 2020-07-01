package com.example.android.basicminecraftquiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextBoxActivity extends AppCompatActivity {


    private static final String LOG_TAG = TextBoxActivity.class.getSimpleName();
    int questionsAsked;

    TextView questionNumberTextView, scoreTextView;
    ImageView imageToIdentifyImageView;
    TextView questionStringTextView;
    EditText answerEditText;

    int[] questionList = {0, 1};
    List<Integer> questionListUnsorted = new ArrayList<>();
    Question question = new Question();
    HeaderFragment header = MainActivity.header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textbox);

        questionNumberTextView = findViewById(R.id.textView_questionNumber);
        scoreTextView = findViewById(R.id.textView_score);

        imageToIdentifyImageView = findViewById(R.id.textboxImageToIdentify);
        questionStringTextView = findViewById(R.id.textbox_question);
        answerEditText = findViewById(R.id.textbox_answerEditText);
        questionStringTextView.setText(question.getQuestion());
        imageToIdentifyImageView.setImageResource(question.getImageID());

        for (int value : questionList) {
            questionListUnsorted.add(value);
        }
        Collections.shuffle(questionListUnsorted);
        questionsAsked = 0;

        nextRound();

        updateHeader();
        questionListUnsorted.add(3);
    }

    void updateHeader() {
        scoreTextView.setText(getString(R.string.score, header.getPoints()));
        questionNumberTextView.setText(getString(R.string.question_number, header.getQuestionNumber()));
    }


    public void nextRound() {
        switch (questionListUnsorted.get(questionsAsked)) {
            case 0:
                question = createQuestionOne();
                displayQuestions(question);
                break;
            case 1:
                question = createQuestionTwo();
                displayQuestions(question);
                break;
            default:
                Intent intent = new Intent(TextBoxActivity.this, GameOver.class);
                startActivity(intent);
        }
    }

    Question createQuestionOne() {
        Question question = new Question();
        question.setQuestion("What do you use to tame this pet?");
        question.setCorrectTextAnswer("wheat");
        question.setImageID(R.drawable.llama);


        return question;
    }

    Question createQuestionTwo() {
        Question question = new Question();
        question.setQuestion("What drops Blaze Rods?");
        question.setCorrectTextAnswer("blaze");
        question.setImageID(R.drawable.blazerod);


        return question;
    }

    public void displayQuestions(Question question) {
        imageToIdentifyImageView.setImageResource(question.imageID);
        questionStringTextView.setText(question.getQuestion());


    }

    public void submitTextAnswer(View view) {
        if (answerEditText.getText().toString().toLowerCase().equals(question.getCorrectTextAnswer())) {
            header.setPoints(header.getPoints() + 1);
        }
        Log.d(LOG_TAG, "Given answer is: " + answerEditText.getText().toString().toLowerCase() + "\n" + "Correct answer is: " + question.getCorrectTextAnswer());
        questionsAsked++;
        header.setQuestionNumber(header.getQuestionNumber() + 1);
        answerEditText.setText("");
        nextRound();
        updateHeader();

    }

}