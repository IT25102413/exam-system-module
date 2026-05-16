package com.exam.service;

import com.exam.model.ExamResult;
import java.io.*;

public class FileService {
    // Relative path pointing directly to your results text file location
    private static final String FILE_NAME = "src/main/java/com/exam/model/results.txt";

    public void saveResultToFile(ExamResult result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            // Commas separate each field so it saves cleanly
            writer.write(result.getStudentId() + "," +
                    result.getExamName() + "," +
                    result.getScore() + "," +
                    result.getGrade() + "," +
                    result.getComment());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }
}