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
@Table(name = "fav")
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  즐겨찾기 번호
    @Column(name = "markerno")
    private Long markerNo;

    //  주문자 닉네임
    @Column(nullable = false)
    private String nickname;

    //  카페 이름
    @Column(nullable = false)
    private String cafename;

    //  카페 전화번호
    @Column(nullable = false)
    private String cafecall;
}
