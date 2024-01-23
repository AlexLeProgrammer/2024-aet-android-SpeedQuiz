package com.example.speedquiz.models;

import android.database.Cursor;

public class Question {
    private String label;
    private int answer;

    /**
     * Constructor.
     * @param label The question's label.
     * @param answer The question's answer.
     */
    public Question(String label, int answer) {
        this.label = label;
        this.answer = answer;
    }

    public Question(Cursor cursor) {
        label = cursor.getString(cursor.getColumnIndexOrThrow("label"));
        answer = cursor.getInt(cursor.getColumnIndexOrThrow("answer"));
    }

    /**
     * @return The question's label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * @return The question's answer.
     */
    public int getAnswer() {
        return answer;
    }
}
