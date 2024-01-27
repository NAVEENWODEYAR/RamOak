package com.ram.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Info")
public class UserInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userMail;
    private String userRoles;
}
