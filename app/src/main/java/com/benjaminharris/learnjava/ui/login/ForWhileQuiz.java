package com.benjaminharris.learnjava.ui.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.benjaminharris.learnjava.R;

import java.util.ArrayList;

public class ForWhileQuiz extends AppCompatActivity {
    private static RadioGroup rg_choices;
    private static RadioButton rb_selected;

    private static RadioButton rb_choiceA;
    private static RadioButton rb_choiceC;
    private static RadioButton rb_choiceB;
    private static TextView jv_question;
    private static TextView qestionNum;

    private static Button b_submit;

    private int currentQuestionIndex;
    private ArrayList<Questions> questions;
    private int questionNumber;
    private int guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_if_else_quiz);
        this.initialize();

    }

    public void initialize()
    {
        rg_choices = (RadioGroup)findViewById(R.id.choices1);
        rb_choiceA = (RadioButton)findViewById(R.id.a_rb);
        rb_choiceB = (RadioButton)findViewById(R.id.b_rb);
        rb_choiceC = (RadioButton)findViewById(R.id.c_rb);
        jv_question = (TextView)findViewById(R.id.questionTextview);
        b_submit = (Button)findViewById(R.id.submit_b);


        questionNumber = 1;
        guesses = 0;
        //start at question 0
        currentQuestionIndex = 0;
        questions = new ArrayList<Questions>();

        questions.add(new Questions("\nWhen you know exactly how many times you want to loop " +
                "through a block of code, use the _____ loop instead of a _____ loop:",
                "for, while","while, for", "while, if", "a"));
        questions.add(new Questions("\n\n" + "What is the output of the following code?"
                + "\n\nfor (int i = 0; i < 5; i++) \n{\n" +
                "  System.out.println(i);\n" +
                "}",
                "5", "0", "4", "c"));
        questions.add(new Questions("In Java the 'for' loop...",
                "executes a target statement as long as a given condition is false",
                "iterates a part of the programs multiple times",
                "is a variable", "b"));
        questions.add(new Questions( "A 'while' loop..\n" ,
                "can execute a block of code as long as a specified condition is reached.",
                "stores an integer value",
                "does not execute code", "a"));
        questions.add(new Questions("\n\n\nPrint 'i' as long as 'i' is less than '6'\n" +
                "\n int i = 1;\n" +
                " _______ (i < 6) \n {\n" +
                "  System.out.println(i); \n" +
                " ______;\n" +
                " }",
                "int, i++",
                "do, i++ ",
                "while, i++", "c"));

        this.displayQuestion( currentQuestionIndex);

        b_submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View w){
                        if (this.answerIsRight()){
                            Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT).show();
                            questionNumber++;
                            guesses++;
                            advance();
                        }else {
                            questionNumber++;
                            guesses++;
                            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();

                        }

                    }
                    private boolean answerIsRight(){
                        String answer = "x";
                        int id = rg_choices.getCheckedRadioButtonId();
                        rb_selected = (RadioButton)findViewById(id);
                        if (rb_selected == rb_choiceA) answer = "a";
                        if (rb_selected == rb_choiceB) answer = "b";
                        if (rb_selected == rb_choiceC) answer = "c";

                        return questions.get(currentQuestionIndex).isCorrectAnswer(answer);
                    }
                }
        );

    }

    private void displayQuestion( int index)
    {
        //displays current question and answers
        jv_question.setText(questions.get(currentQuestionIndex).getQuestionText());
        rb_choiceA.setText(questions.get(currentQuestionIndex).getChoiceA());
        rb_choiceB.setText(questions.get(currentQuestionIndex).getChoiceB());
        rb_choiceC.setText(questions.get(currentQuestionIndex).getChoiceC());
        rg_choices.clearCheck();
    }
    //increments array and goes back to zero
    private void advance() {
        if (currentQuestionIndex != 4) {

            currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
            displayQuestion((currentQuestionIndex));

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You scored: " + (int)(5/(double) guesses *100) + "% out of 5 questions with " + guesses + " guesses");
            builder.setCancelable(false);
            builder.setPositiveButton("Return to Home Page", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }



    }

}

