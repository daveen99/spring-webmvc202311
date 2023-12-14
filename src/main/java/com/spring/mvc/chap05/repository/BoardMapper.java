package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.common.Page;
import com.spring.mvc.chap05.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 목록조회
    List<Board> findAll(Page page);

    // 상세조회
    Board findOne(int boardNo);

    // 게시물등록
    boolean save(Board board);

    // 게시물 삭제
    boolean deleteByNo(int boardNo);

    // 조회수 상승
    // default와 {}를 걸어놓으면 강제 오버라이드가 요구되지않는다.
    boolean updateViewCount(int boardNo);

    // 총 게시물 수 구하기
    int count();
}
