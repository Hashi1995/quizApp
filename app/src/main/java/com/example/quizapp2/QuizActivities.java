package com.example.quizapp2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivities extends AppCompatActivity {

    private TextView textQuestion;
    private RadioGroup groupOptions;
    private Button btnsubmit, btnnext;
    private ProgressBar barprogress;

    private String enterName;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "What is the National animal of Australia?", "Name the longest river in the world?", "How many Continents are there in the World?",
    };
    private String[][] options = {
            {"Lion", "Kangaroo", "Beaver", "Elephant"},
            {"Yangtze", "Amazon", "Nile", "Mississippi"},
            {"Five", "Seven", "Ten", "Three"}
    };
    private int[] correctAnswers = {1, 2, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        textQuestion = findViewById(R.id.textQuestion);
        groupOptions = findViewById(R.id.groupOptions);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnnext = findViewById(R.id.btnnext);
        barprogress = findViewById(R.id.barprogress);


        enterName = getIntent().getStringExtra("Enter_Name");


        questionDisplay();

        btnsubmit.setOnClickListener(v -> {
            int selectedOptionId = groupOptions.getCheckedRadioButtonId();
            if (selectedOptionId == -1) {
                // No option selected
                return;
            }

            RadioButton selectedRadioButton = findViewById(selectedOptionId);
            int selectedAnswerIndex = groupOptions.indexOfChild(selectedRadioButton);

            if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
                score++;
                selectedRadioButton.setTextColor(Color.parseColor("#388E3C"));
            } else {
                selectedRadioButton.setTextColor(Color.parseColor("#D32F2F"));
            }

            btnnext.setVisibility(View.VISIBLE);
            btnsubmit.setVisibility(View.GONE);
        });

        btnnext.setOnClickListener(v -> {
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                questionDisplay();
            } else {
                Intent intent = new Intent(QuizActivities.this, ResultActivies.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
            }
        });
    }

    private void  questionDisplay() {
        if (currentQuestionIndex < questions.length) {
            textQuestion.setText(questions[currentQuestionIndex]);


            groupOptions.clearCheck();


            for (int i = 0; i < 4; i++) {
                RadioButton radioButton = (RadioButton) groupOptions.getChildAt(i);
                radioButton.setText(options[currentQuestionIndex][i]);
                radioButton.setTextColor(getResources().getColor(android.R.color.black)); // Reset text color
            }

            barprogress.setProgress((currentQuestionIndex + 1) * 100 / questions.length);


            btnnext.setVisibility(View.GONE);
            btnsubmit.setVisibility(View.VISIBLE);
        }
    }
}
