package ZooZoo.Controller;

import ZooZoo.Service.MemberService;
import ZooZoo.domain.DTO.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    // 시작 - 메인화면
    /*@GetMapping("/")
    public String goToMain() {return "Main";}*/
    // 로그인화면으로
    @GetMapping("/Member/Login")
    public String goToLogin() {return "Member/Login";}
    // 일반 회원가입으로
    @GetMapping("/Member/SignUp")
    public String goToSignUp() {return "Member/SignUp";}
    // 기업 회원가입으로
    @GetMapping("/Member/CompanySignUp")
    public String goToCompanySignUp() {return "Member/CompanySignUp";}
    // 아이디 찾기로
    @GetMapping("/Member/FindId")
    public String goToFindId() {return "Member/FindId";}
    // 비밀번호 찾기로
    @GetMapping("/Member/FindPw")
    public String goToFindPw() {return "Member/FindPw";}

    // 회원가입
    @PostMapping("/Member/SignUpController") @ResponseBody
    public String SignUp(MemberDTO memberDTO) {
        System.out.println(memberDTO.getMid());
        boolean result = memberService.SignUp(memberDTO);
        if(result) {
            return "1";
        } else {
            return "2";
        }
    }
    @Autowired
    HttpServletRequest request;

    @PostMapping("/member/findpwcontroller")
    public String findpwcontroller(MemberDTO memberDto, Model model) {

        String mid = request.getParameter("mid");
        String memail = request.getParameter("memail");
        String result = memberService.findpw(mid, memail);
        System.out.println("result : " + result);
        if (result != null) {
            String msg = " 회원님의 비밀번호 : " + result;
            model.addAttribute("findpwmsg", msg);
        } else {
            String msg = " 동일한 회원정보가 없습니다.";
            model.addAttribute("findpwmsg", msg);
        }

        return "Member/FindPw";
    }
}
