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
@EqualsAndHashCode(of = "orderNo")
@ToString
@Entity
@Table(name = "orderby")
public class Orderby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  주문 번호
    @Column(name = "orderNo")
    private Long orderNo;

    //  주문자 닉네임
    @Column(nullable = false, length=100)
    private String nickname;

    //  주문 한것
    @Column(nullable = false)
    private String orders;

    //  주문 수량
    @Column(nullable = false)
    private int cafenum;

    //  카페 위치
    @Column(nullable = false)
    private String place;
}
