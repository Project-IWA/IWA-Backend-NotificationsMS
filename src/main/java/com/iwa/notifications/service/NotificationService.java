package com.iwa.notifications.service;

import com.iwa.notifications.exception.NotificationNotFoundException;
import com.iwa.notifications.model.NotificationEntity;
import com.iwa.notifications.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationEntity> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public NotificationEntity getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification not found with id " + id));
    }

    public NotificationEntity saveNotification(NotificationEntity notification) {
        return notificationRepository.save(notification);
    }

    public NotificationEntity updateNotification(Long id, NotificationEntity notificationDetails) {
        NotificationEntity notification = notificationRepository.findById(id).orElseThrow(() -> new NotificationNotFoundException("Notification not found"));
        notification.setIdUser(notificationDetails.getIdUser());
        notification.setIdAdmin(notificationDetails.getIdAdmin());
        notification.setType(notificationDetails.getType());
        notification.setDate(notificationDetails.getDate());
        notification.setEtat(notificationDetails.getEtat());
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        NotificationEntity notification = getNotificationById(id);
        notificationRepository.delete(notification);
    }

}
