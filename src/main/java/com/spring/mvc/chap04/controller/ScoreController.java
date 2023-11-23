package com.spring.mvc.chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 *  # 컨트롤러
 *  - 클라이언트의 요청을 받아서 처리하고 응답을 제공하는 객체다
 *
 *  # 요청 URL Endpoint
 *  1. 학생의 성적정보 등록 폼 화면을 보여주고
 *     동시에 지금까지 저장되어 있는 성적 정보 목록을 조회
 *  - /score/list : GET 방식
 *
 *  2. 학생의 입력된 성적정보를 데이터베이스에 저장하는 요청
 *  - /score/register : POST 방식
 *
 *  3. 성적정보를 삭제 요청
 *  - /score/remove : GET or POST 방식
 *
 *  4. 성적정보 상세 조회 요청
 *  - /score/detail : GET 방식
 */

@Controller
@RequestMapping("/score")
public class ScoreController {

    // 1. 성적 폼 띄우기 + 목록조회 요청
    // - jsp파일로 화면을 띄워줘야 함
    // - 저장된 성적정보 리스트를 jsp에 보내줘야 함
    // - 저장된 성적정보 리스트를 어떻게 가져오느냐 from 데이터베이스
    @GetMapping("/list")
    public String List() {
        System.out.println("/score/list GET !!");
        return "";
    }

    // 2. 성적정보를 데이터베이스에 저장하는 요청
    @PostMapping("/register")
    public String Register() {
        System.out.println("/score/register POST !!");
        return "";
    }

    // 3. 성적정보를 삭제 요청                    GET방식 + POST방식 동시사용 가능
    @RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
    public String Remove(HttpServletRequest request) {
        System.out.printf("/score/remove %s !!\n", request.getMethod());
        return "";
    }

    // 4. 성적정보 상세 조회 요청
    @GetMapping("/detail")
    public String Detail() {
        System.out.println("/score/detail GET !!");
        return "";
    }
}
