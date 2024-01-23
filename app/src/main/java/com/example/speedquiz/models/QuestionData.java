package com.example.speedquiz.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionData {
    private ArrayList<Question> questionsList = new ArrayList<>();

    /**
     * Constructor.
     * @param context Context of the application to pass the query.
     */
    public QuestionData(Context context) {
        initQuestionList(context);
    }

    /**
     * @return The question list.
     */
    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }

    /**
     * Load the question list from the a DB.
     * @param context Context of the application to pass the query.
     */
    private void initQuestionList(Context context) {
        SpeedQuizSqLite helper = new SpeedQuizSqLite(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true, "quiz", new String[] { "idQuiz", "label", "answer" },
                null, null, null, null, "idquiz", null);

        while (cursor.moveToNext()) {
            questionsList.add(new Question(cursor));
        }

        cursor.close();
        db.close();
    }
}
