package com.servlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        // Add sample questions
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Rome", "Berlin"}, 0));
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1));
        currentQuestionIndex = 0;
        score = 0;
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public void submitAnswer(int answerIndex) {
        Question question = getCurrentQuestion();
        if (question != null && question.getCorrectAnswerIndex() == answerIndex) {
            score++;
        }
        currentQuestionIndex++;
    }

    public boolean hasMoreQuestions() {
        return currentQuestionIndex < questions.size();
    }

    public int getScore() {
        return score;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
