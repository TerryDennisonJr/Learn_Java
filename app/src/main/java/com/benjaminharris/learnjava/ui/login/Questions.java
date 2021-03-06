package com.benjaminharris.learnjava.ui.login;

public class Questions
{
    private String questionText;
    private String choiceA;
    private String choiceB;
    private String choiceC;

    private String correctAnswer;
    private boolean creditAlreadyGiven;

    public Questions(String questionText, String choiceA, String choiceB, String choiceC, String correctAnswer) {
        this.questionText = questionText;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.correctAnswer = correctAnswer;

        //initially, no credit given
        this.creditAlreadyGiven = false;

    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCreditAlreadyGiven() {
        return creditAlreadyGiven;
    }

    public void setCreditAlreadyGiven(boolean creditAlreadyGiven) {
        this.creditAlreadyGiven = creditAlreadyGiven;
    }

    //Give credit to correct question

    public boolean isCorrectAnswer(String selectedAnswer)
    {
        return (selectedAnswer.equals(correctAnswer));
    }

    public String toString()
    {
        return questionText;
    }
}

