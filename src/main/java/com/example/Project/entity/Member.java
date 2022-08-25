package com.example.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member {

    @Column(nullable = false, length = 30)
    private String frontSSN;
    @Column(nullable = false, length = 30)
    private String backSSN;
    @Id
    @Column(nullable = false, length = 30)
    private String email;
    @Column(nullable = false, length = 30)
    private String pwd;
    @Column(nullable = false, length = 30)
    private String phone;
    @Column(nullable = false, length = 30)
    private int age;

}
