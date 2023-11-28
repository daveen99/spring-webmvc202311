package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap05.entity.Board;

import java.util.List;

public interface BoardRepository {
    // 게시물 전체 조회
    List<Board> selectAll();

    // 게시물 등록
    boolean save(Board board);

    // 게시물 삭제
    boolean delete(int boardNo);

    // 게시물 상세 조회
    Board findOne(int boardNo);
}
