package com.example.CoolabSpring.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
    private Long teamid;
    private Long userid;
    private Long boardid;
    private LocalDateTime createDate;
    private Integer read;

    public Teams(Long userid, Long boardid) {
        this.userid = userid;
        this.boardid = boardid;
    }
}