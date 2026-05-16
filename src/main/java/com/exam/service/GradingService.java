package com.exam.service;

import com.exam.model.ExamResult;

public class GradingService {

    // 1. Core Evaluation: Converts marks to Letter Grades
    public String calculateGrade(int score) {
        if (score >= 75) return "A";
        if (score >= 65) return "B";
        if (score >= 50) return "C";
        if (score >= 35) return "S";
        return "F";
    }

    // 2. Dynamic Comments: The custom messages you wanted!
    public String generateComment(String grade) {
        switch (grade) {
            case "A":
                return "Super Congratulations! Outstanding achievement! 🏆";
            case "B":
                return "Great job! Keep up the excellent work! 🌟";
            case "C":
                return "Good effort! You can push even higher next time! 👍";
            case "S":
                return "Passable, but room to improve. Try and try again! 📚";
            default: // For Grade F
                return "Don't lose heart! Review your weak spots and try, try again! 💪";
        }
    }

    // 3. Object Assembler: Combines everything into an ExamResult object structure
    public ExamResult processExamScore(String studentId, String examName, int score) {
        String grade = calculateGrade(score);
        String comment = generateComment(grade);
        return new ExamResult(studentId, examName, score, grade, comment);
    }
}
