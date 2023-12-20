package com.spring.mvc.chap05.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
public class Page {

    private int pageNo; // 클라이언트가 보낸 페이지 번호
    private int amount; // 클라이언트가 보낸 게시물목록 수

    public Page() {
        this.pageNo = 1;
        this.amount = 6;
    }
    public Page(int amount) {
        this.amount = amount;
    }



    /*
        만약에 한페이지에 게시물을 6개씩 부린다고 가정하면

        1페이지 -> limit 0, 6
        2페이지 -> limit 6, 6
        3페이지 -> limit 12, 6

        만약에 한페이지에 게시물을 n개씩 뿌린다고 가정하면

        1페이지 -> limit 0, n
        2페이지 -> limit 10, n
        3페이지 -> limit 20, n
        m페이지 -> limit (m - 1) * n, n
     */

    public int getPageStart() {
        return (pageNo - 1) * amount;
    }
}
