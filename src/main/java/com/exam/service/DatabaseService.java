package com.exam.service;

import com.exam.model.ExamResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseService {
    // Connects to your newly created MySQL database
    private static final String URL = "jdbc:mysql://localhost:3306/exam_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void saveResult(ExamResult result) {
        String query = "INSERT INTO exam_results (student_id, exam_name, score, grade, comment) VALUES (?, ?, ?, ?, ?)";
        try {
            // Load the MySQL database connector driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, result.getStudentId());
                pstmt.setString(2, result.getExamName());
                pstmt.setInt(3, result.getScore());
                pstmt.setString(4, result.getGrade());
                pstmt.setString(5, result.getComment());

                pstmt.executeUpdate();
                System.out.println("🎉 Success! Saved directly to your MySQL database.");
            }
        } catch (Exception e) {
            System.out.println("❌ Database saving error!");
            e.printStackTrace();
        }
    }
}