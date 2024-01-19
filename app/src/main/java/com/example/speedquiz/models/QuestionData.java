package com.example.speedquiz.models;

import java.util.ArrayList;

public class QuestionData {
    private ArrayList<Question> questionsList = new ArrayList<>();

    /**
     * @return The question list.
     */
    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }

    /**
     * Create questions.
     */
    public void createQuestions() {
        questionsList.add(new Question("La Grande Muraille de Chine est visible depuis la Lune.", false));
        questionsList.add(new Question("La France est le pays le plus visité au monde.", true));
        questionsList.add(new Question("La mer Morte est l'endroit le plus bas de la Terre.", true));
        questionsList.add(new Question("La Banque mondiale est une organisation financière internationale.", true));
        questionsList.add(new Question("Le mont Everest est la plus haute montagne du monde.", true));
        questionsList.add(new Question("La muraille d'Hadrien a été construite en Égypte.", false));
        questionsList.add(new Question("La guerre de Sécession aux États-Unis a eu lieu au 18e siècle.", false));
        questionsList.add(new Question("La Statue de la Liberté a été un cadeau de la France aux États-Unis.", true));
        questionsList.add(new Question("Les koalas sont des marsupiaux originaires d'Australie.", true));
        questionsList.add(new Question("La Tour Eiffel a été initialement construite comme une antenne de communication.", false));
        questionsList.add(new Question("La Chine est le pays le plus peuplé du monde.", true));
        questionsList.add(new Question("Les pyramides de Gizeh ont été construites par les Romains.", false));
        questionsList.add(new Question("La reine Elizabeth II est le monarque le plus ancien de l'histoire britannique.", false));
        questionsList.add(new Question("La rivière Amazon est la plus longue du monde.", true));
        questionsList.add(new Question("La boussole a été inventée en Chine.", true));
        questionsList.add(new Question("La première guerre mondiale a duré 20 ans.", false));
        questionsList.add(new Question("La planète la plus proche du soleil est Venus.", false));
        questionsList.add(new Question("La déclaration d'indépendance des États-Unis a été signée en 1776.", true));
        questionsList.add(new Question("La pizza a été inventée en Italie.", true));
        questionsList.add(new Question("Le Japon est constitué d'un seul continent.", false));
    }
}
