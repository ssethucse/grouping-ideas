package com.gi.groupingideas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document("User")
@Data
public class User {

    @Id
    private String id;

    private String name;
    private String exp;
    private String skills;
    private String type;
    private String availableSlot;
    private long contributedProjCount;
    private long contributedHoursCount;
    private long earned;
    private Timestamp joinedDate;
    private Timestamp updatedDate;
}
