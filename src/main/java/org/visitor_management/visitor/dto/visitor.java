package org.visitor_management.visitor.dto;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int slno;
    private String name;
    private String email;
    private long phone;
    private String reason;
    private String toMeet;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    
}
