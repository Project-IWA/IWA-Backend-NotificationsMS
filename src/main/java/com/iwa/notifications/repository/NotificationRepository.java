package com.iwa.notifications.repository;

import com.iwa.notifications.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository.
}
