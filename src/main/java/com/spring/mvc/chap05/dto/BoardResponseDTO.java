package com.spring.mvc.chap05.dto;

import com.spring.mvc.chap05.entity.Board;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@RequiredArgsConstructor // final만 골라서 초기화
@Getter
@ToString
@EqualsAndHashCode
public class BoardResponseDTO {
    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private String date; // 작성일자시간

    private String shortTitle;
    private String shortContent;

    public BoardResponseDTO(Board board) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = board.getRegDateTime().format(formatter);
        this.boardNo = board.getBoardNo();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.viewCount = board.getViewCount();
        this.date = formattedDate;
        this.shortTitle = makeShortTitle(board.getTitle());
        this.shortContent = makeShortContent(board.getContent());
    }

    public String makeShortTitle(String originalTitle) {
        String shortTitle = "";
        if(originalTitle.length() >= 8) {
            for(int i = 0; i < 7; i++) {
                shortTitle += originalTitle.charAt(i);
            }
            shortTitle += "...";
            return shortTitle;
        }
        return originalTitle;
    }
    public String makeShortContent(String originalContent) {
        String shortContent = "";
        if(originalContent.length() >= 30) {
            for(int i = 0; i < 30; i++) {
                shortContent += originalContent.charAt(i);
            }
            shortContent += "...";
            return shortContent;
        }
        return originalContent;
    }

}
