package com.iwa.notifications.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "notifier")
@Data               // Generates getters, setters, toString, equals, and hashCode methods
@Builder            // Provides a builder pattern for object creation
@NoArgsConstructor  // Generates a no-args constructor
@AllArgsConstructor // Generates a constructor with all fields as arguments
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")  // This maps the field to the id_notification column in the database
    private Long idNotification;

    @Column(name = "id_user")
    private Long idUser;

    // Opionnal
    @Column(name = "id_admin")
    private Long idAdmin;

    @Enumerated(EnumType.STRING)
    private Etat etat; // "En attente", "Validée"

    @Enumerated(EnumType.STRING)
    private Type type; // "Suppression", "Validation"

    private Date date;
}
