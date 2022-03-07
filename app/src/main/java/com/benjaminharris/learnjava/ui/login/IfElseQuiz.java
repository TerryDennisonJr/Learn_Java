package com.benjaminharris.learnjava.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.benjaminharris.learnjava.R;

import java.util.ArrayList;

public class IfElseQuiz extends AppCompatActivity {

    private static RadioGroup rg_choices;
    private static RadioButton rb_selected;

    private static RadioButton rb_choiceA;
    private static RadioButton rb_choiceC;
    private static RadioButton rb_choiceB;
    private static TextView jv_question;

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

        questions.add(new Questions("An 'if' statement is...", "Erroneous piece of code",
                "the most simple decision-making statement", "a variable", "b"));
        questions.add(new Questions("\n " + "What will be the output of the following program?\n" +
                "        \n" +
                "        if( 1 > 2 )\n" +
                "        {\n" +
                "            System.out.println(\" 1 is greater than 2\");\n" +
                "        }\n" +
                "        else\n" +
                "            System.out.println(\" 2 is greater than 1\");\n" +
                "        \n" +
                "       }\n"
                , "1 is greater than 2", "2 is greater than 1", "neither", "b"));
        questions.add(new Questions(" How many choices are possible when using a single if-else statement?",
                "2", "1", "3", "a"));
        questions.add(new Questions("\n\n\n " + "What will be the output of the following program?\n" + "\n int a = 25;\n" +
                "\n if(a < 25)\n" +
                "     }\n System.out.println(\"1\");\n" +

                "     }     else\n" +
                " System.out.println(\"3\");" ,
                "3", "1", "compile error", "a"));
        questions.add(new Questions("What does the 'Else' statement mean?", "There is nothing else to do",
                "an alternative statement that is executed if the result of a previous test condition evaluates to false",
                "There is something else to be executed", "b"));

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