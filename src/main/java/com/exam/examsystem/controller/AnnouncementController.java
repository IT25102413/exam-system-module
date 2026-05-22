package com.exam.examsystem.controller;

import com.exam.examsystem.model.Announcement;
import com.exam.examsystem.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin(origins = "*") // Allows your front-end script to connect without CORS errors
public class AnnouncementController {

    @Autowired
    private AnnouncementRepository announcementRepository;

    // 1. GET all announcements (frontend: fetch(BASE + '/announcements'))
    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    // 2. POST a new announcement (frontend: method:'POST', body: JSON)
    @PostMapping
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    // 3. DELETE an announcement by ID (frontend: deleteAnnouncement(id))
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable Long id) {
        return announcementRepository.findById(id)
                .map(announcement -> {
                    announcementRepository.delete(announcement);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
