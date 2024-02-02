package com.example.speedquiz.controllers;

import android.os.Handler;
import android.os.Looper;

import com.example.speedquiz.GameActivity;
import com.example.speedquiz.models.QuestionData;

public class GameManager {
    // Constants
    private final int QUESTION_TIME = 2000;

    // Global variables
    private QuestionData questionData;
    private GameActivity gameActivity;
    private int questionIndex = 0;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private boolean gameEnded = false;

    // Timer
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private Runnable nextQuestionRunnable = new Runnable() {
        @Override
        public void run() {
            // Display the next question
            nextQuestion();

            // Restart the timer
            mainHandler.postDelayed(this, QUESTION_TIME);
        }
    };
    /**
     * Initialize the game
     */
    public void initGame() {
        // Start the delay
        mainHandler.postDelayed(nextQuestionRunnable, QUESTION_TIME);
    }

    /**
     * Restart the game.
     */
    public void restart() {
        gameEnded = false;
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        gameActivity.setScores(0, 0);
        questionIndex = 0;
        displayQuestion();
        mainHandler.postDelayed(nextQuestionRunnable, QUESTION_TIME);
    }

    /**
     * Display the actual question.
     */
    public void displayQuestion() {
        gameActivity.setQuestion(questionData.getQuestionsList().get(questionIndex).getLabel());
    }

    /**
     * Display the next question or finish the game if there is no more questions.
     */
    public void nextQuestion() {
        questionIndex++;

        if (questionIndex >= questionData.getQuestionsList().size()) {
            gameEnded = true;
            gameActivity.endGame();

            // Stop the timer
            mainHandler.removeCallbacks(nextQuestionRunnable);
        } else {
            displayQuestion();
        }
    }

    /**
     * Add score and change question.
     * @param player False : player1, true : player2
     */
    public void play(boolean player) {
        if (!gameEnded) {
            // Calculate the scores
            if (player) {
                if (questionData.getQuestionsList().get(questionIndex).getAnswer() == 1) {
                    scorePlayer2++;
                } else {
                    scorePlayer2--;
                }
            } else {
                if (questionData.getQuestionsList().get(questionIndex).getAnswer() == 1) {
                    scorePlayer1++;
                } else {
                    scorePlayer1--;
                }
            }

            // Display the scores
            gameActivity.setScores(scorePlayer1, scorePlayer2);

            // Display the next question
            nextQuestion();

            // Reset and start the timer
            mainHandler.removeCallbacks(nextQuestionRunnable);
            mainHandler.postDelayed(nextQuestionRunnable, QUESTION_TIME);
        }
    }

    /**
     * Set the gameActivity variable.
     * @param gameActivity The GameActivity to pass in this.gameActivity.
     */
    public void setGameActivity(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
    }

    /**
     * Set the questionData variable.
     * @param questionData The QuestionData to pass in this.questionData.
     */
    public void setQuestionData(QuestionData questionData) {
        this.questionData  = questionData;
    }
}
