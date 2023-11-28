package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap04.dto.ScoreResponseDTO;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.service.ScoreService;
import com.spring.mvc.chap05.dto.BoardRequestDTO;
import com.spring.mvc.chap05.dto.BoardResponseDTO;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor // final이 붙은 필드를 초기화하는 생성자를 생성
public class BoardController {

    private final BoardService service;

    // 1. 목록 조회 요청 ("/board/list" : GET)
    @GetMapping("/list")
    public String List(Model model) {
        List<BoardResponseDTO> dtoList = service.getList();

        model.addAttribute("bList", dtoList);
        return "chap05/list";
    }


    // 2. 글쓰기 화면 요청 ("/board/write" : GET)
    @GetMapping("/write")
    public String Write() {

        return "chap05/write";
    }

    // 3. 글쓰기 등록 요청 ("/board/write" : POST)
    @PostMapping("/write")
    public String Write(String title, String content) {
        BoardRequestDTO dto = new BoardRequestDTO(title, content);
        service.insertBoard(dto);

        return "redirect:/board/list";
    }

    // 4. 글 삭제 요청 ("/board/delete" : GET)
    @GetMapping("/delete")
    public String Delete(int bno) {
        System.out.println("삭제할 게시물번호: " + bno);

        service.deleteBoard(bno);

        return "redirect:/board/list";
        // return "chap05/list";
    }

    // 5. 글 상세보기 요청 ("/board/detail" : GET)
    @GetMapping("/detail")
    public String Detail(int bno, Model model) {

        Board board = service.detailBoard(bno);
        BoardResponseDTO dto = new BoardResponseDTO(board);
        model.addAttribute("b", dto);

        return "chap05/detail";
    }
}
