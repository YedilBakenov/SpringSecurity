package com.example.sec.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDTO {
    private int id;
    private String name;
    private int price;
    private String grade;
    private int point;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
