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

    // Only the admin can get all notifications, and it is handled in the api-gateway
    @GetMapping
    public ResponseEntity<List<NotificationEntity>> getAllNotifications() {
        List<NotificationEntity> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    // Not used in the frontend
    @GetMapping("/{id}")
    public ResponseEntity<NotificationEntity> getNotification(@PathVariable Long id) {
        try {
            NotificationEntity notification = notificationService.getNotificationById(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        } catch (NotificationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found", e);
        }
    }

    // Only the user that is logged in can create a notification for himself
    @PostMapping
    public ResponseEntity<NotificationEntity> createNotification(
            @RequestHeader("AuthUserId") Long userId,
            @RequestHeader("AuthUsername") String username,
            @RequestHeader("AuthUserRole") String role,
            @RequestBody NotificationEntity notification) {

        // Use the userId, username, and role as needed
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);

        //Check if the userId is the same as the one in the notification object in the body
        // If not, return a 403 Forbidden response
        if(userId != notification.getIdUser()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        // check if the idUser is different from the idAdmin
        if(notification.getIdUser() == notification.getIdAdmin()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        NotificationEntity createdNotification = notificationService.saveNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }


    // Only the admin can update a notification, and it is handled in the api-gateway
    @PutMapping("/{idNotification}")
    public ResponseEntity<NotificationEntity> updateNotification(@PathVariable Long idNotification, @RequestBody NotificationEntity notificationDetails) {
        try {
            NotificationEntity updatedNotification = notificationService.updateNotification(idNotification, notificationDetails);
            return new ResponseEntity<>(updatedNotification, HttpStatus.OK);
        } catch (NotificationNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found", e);
        }
    }

    // Only the admin can delete a notification, and it is handled in the api-gateway
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
