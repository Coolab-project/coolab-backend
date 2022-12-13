package com.example.CoolabSpring.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long boardId;
    private String teamname;
    private int maxpeople;
    private int template;
    private LocalDateTime createDate;
    private Integer read;
    private String subscription;

    private Long memberId;


    public Board(String teamname, int maxpeople, String subscription, int template) {
        this.teamname = teamname;
        this.maxpeople = maxpeople;
        this.subscription = subscription;
        this.template = template;
    }
    public Long findid() {
        return memberId;
    }

}

