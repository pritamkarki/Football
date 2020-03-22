package com.example.football;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    public int counter;
    Button startTheGame;
    TextView gameTimerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);

        counter = 30;
        startTheGame = findViewById(R.id.start_button);
        gameTimerView = findViewById(R.id.gameTimer);
        gameTimerView.setText("30");

        startTheGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        gameTimerView.setText(String.valueOf(counter));
                        counter--;
                    }
                    public  void onFinish(){
                        if (scoreTeamA > scoreTeamB){
                            gameTimerView.setText("Chelsea is the Winner!");
                        }
                        else if (scoreTeamB > scoreTeamA){
                            gameTimerView.setText("Manchester United is the Winner!");
                        }  else {
                            gameTimerView.setText("It's a drew");
                        }
                    }
                }.start();

            }
        });
    }

    /* Display Team A Score */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }


    public void freeThrowTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /* Display Team B Score */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void freeThrowTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }


    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        gameTimerView.setText("30");
        counter = 30;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

}
