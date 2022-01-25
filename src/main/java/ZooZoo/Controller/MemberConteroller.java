package ZooZoo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberConteroller {
    // 회원가입
    @GetMapping("/Member/SignUp")
    public String goToSignUp() {
        return "Member/SignUp";
    }
    // 아이디 찾기
    @GetMapping("/Member/FindId")
    public String goToFindId() {
        return "Member/FindId";
    }
    // 비밀번호 찾기
    @GetMapping("/Member/FindPw")
    public String goToFindPw() {
        return "Member/FindPw";
    }

}
