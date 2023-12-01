package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Board;

import java.util.List;

public interface BoardRepository {
    // 목록조회
    List<Board> findAll();

    // 상세조회
    Board findOne(int boardNo);

    // 게시물등록
    boolean save(Board board);

    // 게시물 삭제
    boolean deleteByNo(int boardNo);
}
