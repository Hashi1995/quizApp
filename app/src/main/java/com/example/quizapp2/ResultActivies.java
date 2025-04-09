package com.example.quizapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivies extends AppCompatActivity {

    private TextView finalScoretext;
    private Button btntakeNewQuiz, btnfinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        finalScoretext = findViewById(R.id.finalScoretext);
        btntakeNewQuiz = findViewById(R.id.btntakeNewQuiz);
        btnfinish = findViewById(R.id.btnfinish);

        int score = getIntent().getIntExtra("SCORE", 0);
        finalScoretext.setText("Final Score: " + score);

        btntakeNewQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivies.this, com.example.quizapp2.MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnfinish.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}
