package com.example.speedquiz.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SpeedQuizSqLite extends SQLiteOpenHelper {
    // Constants
    static String DB_NAME = "SpeedQuiz.db";
    static int DB_VERSION = 1;


    public SpeedQuizSqLite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table quiz
        db.execSQL("CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY, label TEXT, answer INTEGER);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Grande Muraille de Chine est visible depuis la Lune.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La France est le pays le plus visité au monde.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La mer Morte est l'endroit le plus bas de la Terre.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Banque mondiale est une organisation financière internationale.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le mont Everest est la plus haute montagne du monde.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La muraille d'Hadrien a été construite en Égypte.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La guerre de Sécession aux États-Unis a eu lieu au 18e siècle.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Statue de la Liberté a été un cadeau de la France aux États-Unis.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Les koalas sont des marsupiaux originaires d'Australie.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Tour Eiffel a été initialement construite comme une antenne de communication.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Chine est le pays le plus peuplé du monde.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Les pyramides de Gizeh ont été construites par les Romains.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La reine Elizabeth II est le monarque le plus ancien de l'histoire britannique.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La rivière Amazon est la plus longue du monde.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La boussole a été inventée en Chine.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La première guerre mondiale a duré 20 ans.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La planète la plus proche du soleil est Venus.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La déclaration d'indépendance des États-Unis a été signée en 1776.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La pizza a été inventée en Italie.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le Japon est constitué d'un seul continent.\", 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
