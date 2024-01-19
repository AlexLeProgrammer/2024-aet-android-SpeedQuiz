package com.example.speedquiz.models;

public class Question {
    private String label;
    private Boolean answer;

    /**
     * Constructor.
     * @param label The question's label.
     * @param answer The question's answer.
     */
    public Question(String label, Boolean answer) {
        this.label = label;
        this.answer = answer;
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
    public Boolean getAnswer() {
        return answer;
    }
}
