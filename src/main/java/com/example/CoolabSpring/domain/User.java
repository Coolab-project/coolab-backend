package com.example.CoolabSpring.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userid;
    private String name;
    private String email;
    private String image;
    private LocalDateTime createDate;
    private Integer read;

    public User(String name, String email, String image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }
}
