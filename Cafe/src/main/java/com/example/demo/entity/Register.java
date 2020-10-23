package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties(value="hibernateLazyInitializer")
@EqualsAndHashCode(of = "userNo")
@ToString
@Entity
@Table(name = "register")
@Data
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userno")
    private int userNo;
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    @Column(name = "pw", nullable = false)
    private String pw;
    @Column(name = "nn", nullable = false, unique = true)
    private String nn;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "em", nullable = false)
    private String em;
    @Column(name = "br", nullable = false)
    private int br;
}
