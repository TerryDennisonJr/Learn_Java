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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArrayQuiz extends AppCompatActivity {

    private static RadioGroup rg_choices;
    private static RadioButton rb_selected;

    private static RadioButton rb_choiceA;
    private static RadioButton rb_choiceC;
    private static RadioButton rb_choiceB;
    private static TextView jv_question;
    private static TextView q_numbers;

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

        //start at question 0
        questionNumber = 1;
        guesses = 0;
        currentQuestionIndex = 0;
        questions = new ArrayList<Questions>();



        questions.add(new Questions("An 'array' is...",
                " an object which contains elements of a similar data type",
                "an object which contains elements of different types",
                "a grid which contains elements of similar data types",
                "a"));
        questions.add(new Questions( "\n\nWhat will be the output of the following program?" + "\n"+
                "\nString[ ] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "\nSystem.out.println(cars[0]);",
                "BMW",
                "Ford",
                "Volvo",
                "c"));
        questions.add(new Questions(" To create an array of integers, you could write:",
                "int [ ] myNum = {10, 20, A, 40};",
                "int [ ] myNum = {10, 20, 30, 40};",
                " myNum = {10, 20, 30, 40};",
                "b"));
        questions.add(new Questions( "\n\n\nWhat will be the output of the following program?" +
                "\n\nString[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "\nfor (String i : cars) \n{\n" +
                "  System.out.println(i);\n" +
                "}" ,
                "Volvo BMW Ford Mazda",
                "BMW Ford",
                "Mazda",
                "a"));
        questions.add(new Questions("Does a programmer always know how long an array will be when the program is being written?",
                "No---arrays can grow to whatever length is needed.",
                "Yes---the program will not compile without the length being declared.",
                "No---the array object is created when the program is running, and the length might change from run to run.",
                "c"));

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



