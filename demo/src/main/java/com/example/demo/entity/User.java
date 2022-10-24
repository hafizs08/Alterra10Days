package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@Builder

@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "noHp")
    private String noHp;

    @Column(name = "gender")
    private String gender;

    @Column(name = "tgl_lahir")
    private Date tglLahir;

}
