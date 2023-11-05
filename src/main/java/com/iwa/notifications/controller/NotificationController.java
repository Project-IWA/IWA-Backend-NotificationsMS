package com.iwa.notifications.controller;

import com.iwa.notifications.exception.NotificationNotFoundException;
import com.iwa.notifications.model.NotificationEntity;
import com.iwa.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<NotificationEntity>> getAllNotifications() {
        List<NotificationEntity> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationEntity> getNotification(@PathVariable Long id) {
        try {
            NotificationEntity notification = notificationService.getNotificationById(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } catch (NotificationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found", e);
        }
    }

    @PostMapping
    public ResponseEntity<NotificationEntity> createNotification(@RequestBody NotificationEntity notification) {
        NotificationEntity createdNotification = notificationService.saveNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationEntity> updateNotification(@PathVariable Long id, @RequestBody NotificationEntity notificationDetails) {
        try {
            NotificationEntity updatedNotification = notificationService.updateNotification(id, notificationDetails);
            return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
        } catch (NotificationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        try {
            notificationService.deleteNotification(id);
            return ResponseEntity.noContent().build();
        } catch (NotificationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found", e);
        }
    }
}
