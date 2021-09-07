package com.digitalinovation.gerenciadorreuniao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meetingRoom")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String startHour;
    @Column(nullable = false)
    private String endHour;



}