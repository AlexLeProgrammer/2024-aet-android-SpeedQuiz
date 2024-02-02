package com.example.speedquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.speedquiz.controllers.GameManager;
import com.example.speedquiz.models.QuestionData;
import com.google.android.material.button.MaterialButton;

public class GameActivity extends AppCompatActivity {

    private TextView TXT_player1_name;
    private TextView TXT_player2_name;

    private TextView TXT_player1_score;
    private TextView TXT_player2_score;
    private TextView TXT_question1;
    private TextView TXT_question2;
    private MaterialButton BT_player1;
    private MaterialButton BT_player2;
    private RelativeLayout RL_end_popup;
    private MaterialButton BT_menu;
    private MaterialButton BT_replay;

    /**
     * Display a question.
     * @param question Question to display.
     */
    public void setQuestion(String question) {
        TXT_question1.setText(question);
        TXT_question2.setText(question);
    }

    /**
     * Set the scores.
     * @param scorePlayer1 Score of the first player.
     * @param scorePlayer2 Score of the second player.
     */
    public void setScores(int scorePlayer1, int scorePlayer2) {
        TXT_player1_score.setText(Integer.toString(scorePlayer1));
        TXT_player2_score.setText(Integer.toString(scorePlayer2));
    }

    /**
     * End the game;
     */
    public void endGame() {
        RL_end_popup.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Récupère les éléments
        TXT_player1_name = findViewById(R.id.game_txt_name1);
        TXT_player2_name = findViewById(R.id.game_txt_name2);
        TXT_player1_score = findViewById(R.id.game_txt_score_player1);
        TXT_player2_score = findViewById(R.id.game_txt_score_player2);
        TXT_question1 = findViewById(R.id.game_txt_question1);
        TXT_question2 = findViewById(R.id.game_txt_question2);
        BT_player1 = findViewById(R.id.game_button_player1);
        BT_player2 = findViewById(R.id.game_button_player2);
        RL_end_popup = findViewById(R.id.game_end_popup);
        BT_menu = findViewById(R.id.game_button_menu);
        BT_replay = findViewById(R.id.game_button_replay);

        // Récupère le nom des joueurs
        Intent GameActivity = getIntent();
        TXT_player1_name.setText(GameActivity.getStringExtra("player1_name"));
        TXT_player2_name.setText(GameActivity.getStringExtra("player2_name"));
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Initialize the game manager
        GameManager gameManager = new GameManager();
        gameManager.setGameActivity(this);
        gameManager.setQuestionData(new QuestionData(this));
        gameManager.initGame();
        gameManager.displayQuestion();

        // Listen to the click of the buttons
        BT_player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.play(false);
            }
        });

        BT_player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.play(true);
            }
        });

        BT_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BT_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameManager.restart();
                RL_end_popup.setVisibility(View.INVISIBLE);
            }
        });
    }
}