package com.exam.examscheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class enrollmentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleExam(@RequestParam Map<String, String> formData) {
        String examName = formData.get("exam_name");
        String examDate = formData.get("exam_date");
        String venue = formData.get("venue");

        String sql = "INSERT INTO Exams (subject_id, exam_name, exam_date, venue) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 1, examName, examDate, venue);

        return ResponseEntity.ok("Exam scheduled successfully!");
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(@RequestParam Map<String, String> formData) {
        String studentId = formData.get("student_id");
        String examId = formData.get("exam_id");

        String sql = "INSERT INTO Enrollments (student_id, exam_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, studentId, examId);

        return ResponseEntity.ok("Student enrolled successfully!");
    }
}