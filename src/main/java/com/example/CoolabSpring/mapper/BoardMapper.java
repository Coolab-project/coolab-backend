package com.example.CoolabSpring.mapper;

import com.example.CoolabSpring.domain.Board;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository

public interface BoardMapper{

    int boardCount();

    List<Board> findAll();

    Board findById(Long boardId);

    Long save(Board board);

    Long update(Board board);

    void delete(Long boardId);
}
