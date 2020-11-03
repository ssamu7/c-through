package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@JsonIgnoreProperties(value="hibernateLazyInitializer")
@Getter
@Setter
@EqualsAndHashCode(of = "markerno")
@ToString
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drinkno")
    private Long drinkNo;

    @Column(nullable = false)
    private String drinkName;

    @Column(nullable = false)
    private String drinkMemo;

    @Column(nullable = false)
    private String drinkType;

    @Column(nullable = false)
    private long drinkPrice;
}
