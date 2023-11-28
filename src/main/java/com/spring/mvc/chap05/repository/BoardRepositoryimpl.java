package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap05.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.time.LocalDateTime.now;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Repository
public class BoardRepositoryimpl implements BoardRepository {

    private static final Map<Integer, Board> boardMap;

    // 게시물번호를 생성할 일련번호
    private static int seq;

    static {
        boardMap = new HashMap<>();

    }


    @Override
    public List<Board> selectAll() {
        return new ArrayList<>(boardMap.values())
                .stream()
                .sorted(comparing(Board::getBoardNo).reversed())
                .collect(toList())
                ;
    }

    @Override
    public boolean save(Board board) {
        // 학번 넣어주기
        board.setBoardNo(++seq);

        boardMap.put(board.getBoardNo(), board);
        return true;
    }

    @Override
    public boolean delete(int boardNo) {
        if (!boardMap.containsKey(boardNo))
            return false;

        boardMap.remove(boardNo);
        return true;
    }

    @Override
    public Board findOne(int boardNo) {
        Board board = boardMap.get(boardNo);
        int count = board.getViewCount();
        board.setViewCount(count+1);

        return board;
    }
}
