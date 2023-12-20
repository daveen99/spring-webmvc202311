package com.spring.mvc.chap05.dto.request;

import com.spring.mvc.chap05.entity.Reply;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// @Setter를 필요할때만 넣는이유
// setter로 인해 일어나는 조작방지를 위해서
@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyPostRequestDTO {

    // NotBlank는 null 안됨! 빈문자열도 안됨!
    // NotNull은 null만 안됨!! 빈문자열은 됨!
    @NotBlank
    @Size(min = 1, max = 300)
    private String text;   // 댓글 내용

    @NotBlank
    @Size(min = 2, max = 8)
    private String author; // 댓글 작성자

    @NotNull
    private Long bno;      // 원본 글번호  (Long -> default null) / (long -> default 0)

    // dto를 entity로 바꾸는 변환 메서드
    public Reply toEntity() {
        return Reply.builder()
                .replyText(this.text)
                .replyWriter(this.author)
                .boardNo(this.bno)
                .build();
    }
}
