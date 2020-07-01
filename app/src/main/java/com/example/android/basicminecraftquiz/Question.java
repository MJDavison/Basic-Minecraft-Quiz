package com.example.android.basicminecraftquiz;

public class Question {

    String correctTextAnswer;
    int imageID;
    String question;

    Question() {
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getCorrectTextAnswer() {
        return correctTextAnswer;
    }

    public void setCorrectTextAnswer(String correctTextAnswer) {
        this.correctTextAnswer = correctTextAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
