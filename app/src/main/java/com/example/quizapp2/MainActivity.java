package com.example.quizapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText enterName;
    private Button btnStartQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterName = findViewById(R.id.enterName);
        btnStartQuiz = findViewById(R.id.btnStartQuiz);

        btnStartQuiz.setOnClickListener(v -> {
            String name = enterName.getText().toString();
            Intent intent = new Intent(MainActivity.this, QuizActivities.class);
            intent.putExtra("Enter_Name", name);
            startActivity(intent);
        });

        //g
    }
}
