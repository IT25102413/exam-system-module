package com.exam;

import com.exam.service.GradingService;
import com.exam.service.FileService;
import com.exam.model.ExamResult;
import com.exam.service.DatabaseService;

public class TestMyCode {
    public static void main(String[] args) {
        GradingService gradingService = new GradingService();
        FileService fileService = new FileService();

        System.out.println("=== STARTING BACKEND TEST ===");

        // 1. Test the Grading Logic
        System.out.println("\n[1/2] Testing Grading Logic...");
        ExamResult result = gradingService.processExamScore("IT25300373", "Java OOP Midterm", 88);
        System.out.println("-> Calculated Grade: " + result.getGrade());
        System.out.println("-> Selected Comment: " + result.getComment());

        // 2. Test File Saving
        System.out.println("\n[2/2] Testing File Storage...");
        fileService.saveResultToFile(result);
        // 3. Test Database Storage
        DatabaseService databaseService = new DatabaseService();
        databaseService.saveResult(result);
        System.out.println("-> Check complete! Look at your results.txt tab.");

        System.out.println("\n=== TEST FINISHED SUCCESSFULLY ===");
    }
}