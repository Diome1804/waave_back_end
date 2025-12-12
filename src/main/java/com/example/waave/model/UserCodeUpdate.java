package com.example.waave.model;


import jakarta.persistence.*;
        import lombok.Data;

@Entity
@Table(name = "user_code_update")
@Data
public class UserCodeUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oldCode;

    private String newCode;

    private String smsCode;
}