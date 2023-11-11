package com.spring.mvc.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/hw")
public class LoginController {
    /*
        1번요청: 로그인 폼 화면 열어주기
        - 요청 URL : /hw/s-login-form : GET
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-form.jsp
        - html form: 아이디랑 비번을 입력받으세요.

        2번요청: 로그인 검증하기
        - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
        - 요청 URL : /hw/s-login-check : POST
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-result.jsp
        - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는경우, 비번 틀린경우

     */
    @GetMapping("/hw/s-login-form")
    public String Login() {
        return "chap03/s-form";
    }

    @PostMapping("/hw/s-login-check")
    public String Login(
            @RequestParam(defaultValue = "none") String id,
            @RequestParam(defaultValue = "none") String pw,
            Model model) {

        String Check;
        if(id.equals("grape111") && pw.equals("ggg9999")) {
            // 로그인 정보가 일치할 경우
            Check = "1";
        } else if (id.equals("grape111")) {
            // 비밀번호가 틀렸을 경우
            Check = "2";
        } else {
            // 아이디가 틀렸을 경우
            Check = "0";
        }
        model.addAttribute("c", Check);

        return "chap03/s-result";
    }
}

