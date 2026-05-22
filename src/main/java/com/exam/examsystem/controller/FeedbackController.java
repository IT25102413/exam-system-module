package com.exam.examsystem.controller;

import com.exam.examsystem.model.Feedback;
import com.exam.examsystem.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*") // Allows your front-end script to connect without CORS errors
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // 1. GET all student feedback (Read)
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // 2. POST student feedback submission (Create)
    @PostMapping
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // 3. PUT (Update) an existing feedback entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedData) {
        return feedbackRepository.findById(id)
                .map(feedback -> {
                    feedback.setStudentName(updatedData.getStudentName());
                    feedback.setMessage(updatedData.getMessage());
                    feedback.setRating(updatedData.getRating());
                    Feedback savedFeedback = feedbackRepository.save(feedback);
                    return ResponseEntity.ok(savedFeedback);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. DELETE a feedback entry by ID (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable Long id) {
        return feedbackRepository.findById(id)
                .map(feedback -> {
                    feedbackRepository.delete(feedback);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}