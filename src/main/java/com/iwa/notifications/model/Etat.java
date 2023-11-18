package com.iwa.notifications.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Etat {
    @JsonProperty("En attente")
    EN_ATTENTE,
    @JsonProperty("Validée")
    VALIDEE;
}

