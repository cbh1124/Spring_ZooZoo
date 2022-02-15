package ZooZoo.Controller.Member;

import ZooZoo.Domain.DTO.Member.MemberDTO;
import ZooZoo.Service.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    HttpServletRequest request;

    // 시작 - 메인화면
    @GetMapping("/")
    public String goToMain(Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("loginDTO") != null) {
            return "LogMain";
        } else {
            return "Main";
        }
    }

    // 로그인화면으로
    @GetMapping("/Member/Login")
    public String goToLogin() {
        return "Member/Login";
    }

    // 일반 회원가입으로
    @GetMapping("/Member/SignUp")
    public String goToSignUp() {
        return "Member/SignUp";
    }

    // 기업 회원가입으로
    @GetMapping("/Member/CompanySignUp")
    public String goToCompanySignUp() {
        return "Member/CompanySignUp";
    }

    // 아이디 찾기로
    @GetMapping("/Member/FindId")
    public String goToFindId() {
        return "Member/FindId";
    }

    // 비밀번호 찾기로
    @GetMapping("/Member/FindPw")
    public String goToFindPw() {
        return "Member/FindPw";
    }

    // 마이페이지로
    @GetMapping("/Member/Myinfo")
    public String goToMyinfo(Model model) {
        // 로그인 세션 호출
        HttpSession session = request.getSession();
        MemberDTO loginDTO = (MemberDTO) session.getAttribute("loginDTO");
        // 회원정보 가져오기
        MemberDTO memberDTO = memberService.getmemberDto(loginDTO.getMno());
        System.out.println("mno : " + loginDTO.getMno());
        // html로 전달
        model.addAttribute("loginDTO", loginDTO);
        model.addAttribute("memberDTO", memberDTO);

        return "Member/Myinfo";
    }


    // 회원가입
    @PostMapping("/Member/SignUpController")
    @ResponseBody
    public String SignUp(MemberDTO memberDTO) {
        boolean result = memberService.SignUp(memberDTO);
        if (result) {
            return "1";
        } else {
            return "2";
        }
    }

    // 아이디 중복체크
    @GetMapping("/Member/Checkid")
    @ResponseBody
    public String CheckID(@RequestParam("mid") String mid) {
        boolean result = memberService.Checkid(mid);
        if (result) {
            return "1";
        } else {
            return "2";
        }
    }

    // 로그인
    @GetMapping("/Member/LoginController")
    @ResponseBody
    public String LoginController(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw) {
        boolean result = memberService.Login(mid, mpw);
        if (result) {
            return "1";
        } else {
            return "2";
        }
    }

    //아이디 찾기
    @ResponseBody
    @PostMapping("/Member/FindIdController")
    public String FindIdController(@RequestParam("memail") String memail,
                                   @RequestParam("mname") String mname,
                                   Model model) {
        //이메일, 패스워드 둘 중 하나라도 공백이거나 null일 경우
        if (memail.equals("") || memail == null || mname.equals("") || mname == null) {
            return "1";
        } else {
            String result = memberService.FindId(memail, mname);
            if (result != null && !result.equals("")) {
                return result;
                //동일한 회원 정보가 없으면
            } else {
                return "2";
            }
        }
    }

    // 비밀번호찾기
    @PostMapping("/Member/FindpwController")
    public String findpwcontroller(Model model) {
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

    // 회원 탈퇴
    @GetMapping("/Member/mdelete")
    @ResponseBody
    public int mdelete(@RequestParam("passwordconfirm") String passwordconfirm) {
        // 로그인 세션 호출
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginDTO");

        // 서비스에 회원번호, 입력 패스워드 보내기
        boolean result = memberService.mdelete(memberDTO.getMno(), passwordconfirm);

        // js로 return 보내기
        if (result) {
            return 1;
        } else {
            return 2;
        }
    }

    //로그아웃
    @GetMapping("/Member/Logout")
    public String logout() {
        HttpSession session = request.getSession();
        session.invalidate(); //모든 세션 끊기
        /*session.setAttribute("logindto",null); //기존 세션 값을 null로 변경하기*/
        return "redirect:/"; //로그아웃 성공시 메인페이지로 이동
    }

    // 회원수정
    @GetMapping("/Member/Update")
    @ResponseBody
    public String memberupdate(@RequestParam("mno") int mno), @RequestParam("newmname") String newmname {
//        memberService.memberupdate(mno, newmname);
    }


}
