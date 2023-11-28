package com.spring.mvc.chap05.service;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.dto.ScoreResponseDTO;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap05.dto.BoardRequestDTO;
import com.spring.mvc.chap05.dto.BoardResponseDTO;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository repository;

    public List<BoardResponseDTO> getList() {
        return repository.selectAll()
                .stream()
                .map(BoardResponseDTO::new)
                .collect(Collectors.toList());
    }

    public boolean deleteBoard(int boardNo) {
        return repository.delete(boardNo);
    }

    public Board detailBoard(int boardNo) {
        return repository.findOne(boardNo);
    }

    public boolean insertBoard(BoardRequestDTO dto) {

        return repository.save(new Board(dto));
    }

}
