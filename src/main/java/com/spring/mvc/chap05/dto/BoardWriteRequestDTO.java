package com.spring.mvc.chap05.dto;

import lombok.*;

@ToString @Getter
@Setter @EqualsAndHashCode
@NoArgsConstructor
public class BoardWriteRequestDTO {

    private String title;
    private String content;
}
