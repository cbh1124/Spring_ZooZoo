package ZooZoo.Controller.Board;

import ZooZoo.Domain.DTO.Board.BoardDTO;
import ZooZoo.Domain.DTO.Board.LossDTO;
import ZooZoo.Domain.DTO.Board.ShareDTO;
import ZooZoo.Domain.DTO.Member.MemberDTO;
import ZooZoo.Domain.DTO.Pagination;
import ZooZoo.Domain.Entity.Board.BoardEntity;
import ZooZoo.Service.Free.FreeBoardService;
import ZooZoo.Service.Loss.LossService;
import ZooZoo.Service.Share.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {
    @Autowired
    ShareService shareService;
    @Autowired
    FreeBoardService freeBoardService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    LossService lossService;

    // 분양게시판으로
    @GetMapping("/ShareBoardList")
    public String goToShareBoardList(Model model, @RequestParam(defaultValue = "1") int page) {
        ShareDTO shareDTO = new ShareDTO();
        ArrayList<ShareDTO> shareDTOS = new ArrayList<>();
        ArrayList<String> petshop = shareService.Share();
        ArrayList<String> oneStep = new ArrayList<>();
        ArrayList<String> twoStep = new ArrayList<>();
        ArrayList<String> threeStep = new ArrayList<>();
        String[] s = new String[petshop.size()];
        int totalSize = petshop.size();
        Pagination paging = new Pagination(totalSize, page);
        int j = 0;
        if (page != 80) {
            for (int i = (page - 1) * 100; i < paging.getPageSize() * page; i++) {
                s[i] = petshop.get(i);
                oneStep.add(s[i].split(":")[0]);
                twoStep.add(s[i].split(":")[1]);
                threeStep.add(s[i].split(":")[2]);
                shareDTOS.add(new ShareDTO(oneStep.get(j), threeStep.get(j), twoStep.get(j)));
                j++;
            }
        } else {
            for (int i = (page - 1) * 100; i < totalSize; i++) {
                s[i] = petshop.get(i);
                oneStep.add(s[i].split(":")[0]);
                twoStep.add(s[i].split(":")[1]);
                threeStep.add(s[i].split(":")[2]);
                shareDTOS.add(new ShareDTO(oneStep.get(j), threeStep.get(j), twoStep.get(j)));
                j++;
            }
        }

        ArrayList<String> selectArr1 = new ArrayList<>();
        ArrayList<String> selectArr = new ArrayList<>();
        for (int i = 0; i < petshop.size() - 1; i++) {
            selectArr1.add(petshop.get(i).split(":")[1]);
            // System.out.println(":::::" + selectArr1.get(i).split("경기도")[0] + " : " + i);
            if (selectArr1.get(i).equals("null")) {
                selectArr.add("정보없음");
            } else {
                if (selectArr1.get(i).split("경기도")[0].contains("인천광역시")) {
                    selectArr.add("인천");
                } else if (selectArr1.get(i).split("경기도")[0].contains("충청남도")) {
                    selectArr.add("충남");
                } else {
                    selectArr.add(selectArr1.get(i).split(" ")[1]);
                }
            }
        }
        model.addAttribute("select", selectArr);
        model.addAttribute("pagination", paging);
        model.addAttribute("share", shareDTOS);
        return "Board/Share/ShareBoardList";
    }

    // 자유게시판으로
    @GetMapping("/freeboard")
    public String GotoFreeBoard(Model model) {
        ArrayList<BoardDTO> boardDTOs = freeBoardService.GetAll();
        model.addAttribute("freeboard", boardDTOs);
        return "Board/Free/FreeBoardMain";
    }

    // 유기게시판으로
    @GetMapping("LossBoardlist")
    public String goToLossBoardList(Model model, @RequestParam(defaultValue = "1") int page) {

        String sex = request.getParameter("sex"); // 성별
        String kind = request.getParameter("kind"); // 축종
        String city = request.getParameter("city"); // 시군구
        String state = request.getParameter("state"); // 시군구
        HttpSession session = request.getSession();

        if (sex != null || kind != null || city != null || state != null) {
            session.setAttribute("sex", sex);
            session.setAttribute("kind", kind);
            session.setAttribute("city", city);
            session.setAttribute("state", state);
        } else {
            sex = (String) session.getAttribute("sex");
            kind = (String) session.getAttribute("kind");
            city = (String) session.getAttribute("city");
            state = (String) session.getAttribute("state");
        }


        ArrayList<LossDTO> parses = lossService.losslist(sex, kind, city, state); // 필터링 게시물
        ArrayList<LossDTO> parsesPage = lossService.parsenum(parses, page); // 페이징

        Pagination pagination = new Pagination(parses.size(), page);

        model.addAttribute("parsesPage", parsesPage);
        model.addAttribute("pagination", pagination);
        return "Board/Loss/LossBoardlist";
    }


    // 상세페이지로
    @GetMapping("/Board/Loss/LossBoardView/{ABDM_IDNTFY_NO}")
    public String goToLossBoardView(Model model, @PathVariable("ABDM_IDNTFY_NO") String ABDM_IDNTFY_NO) {
        ArrayList<LossDTO> lossDTOS = lossService.getlossboard(ABDM_IDNTFY_NO);
        // 세션 호출
        HttpSession session = request.getSession();
        MemberDTO memberDto = (MemberDTO) session.getAttribute("loginDTO");
        String apikey = lossDTOS.get(0).getABDM_IDNTFY_NO();
        int cano = 1;

        System.out.println(apikey + "," + cano);
        // 해당 게시물 댓글 호출
        List<BoardEntity> replyEntities = lossService.getreplylist(apikey, cano);

        model.addAttribute("loginDTO",memberDto);
        model.addAttribute("lossDTOS", lossDTOS);
        model.addAttribute("replyEntities", replyEntities);
        return "Board/Loss/LossBoardView";
    }


    @GetMapping("/Board/Free/FreeBoardView")
    public String goToFreeBoardView() {
        return "Board/Free/FreeBoardView";
    }

    @GetMapping("/ShareBoardView/{shareno}")
    public String SBView(ShareDTO shareDTO, Model model) {
        String no = shareDTO.getShareno();
        String sno = no.split(",")[0];
        String s_no = sno.split("=")[1];
        String name = no.split(",")[1];
        String sname = name.split("=")[1];
        String address = no.split(",")[2];
        String saddress = address.split("=")[1];

        ShareDTO dto = new ShareDTO();
        dto.setShareno(s_no);
        dto.setSharename(sname);
        dto.setShareaddress(saddress);
        model.addAttribute("shareDTO", dto);
        return "Board/Share/ShareBoardView";
    }

    // 댓글 작성
    @GetMapping("/replywrite")
    @ResponseBody
    public String replywrite(@RequestParam("apikey") String apikey,
                             @RequestParam("cano") int cano,
                             @RequestParam("rcontents") String rcontents,Model model) {
        HttpSession session = request.getSession();
        MemberDTO memberDto = (MemberDTO) session.getAttribute("loginDTO");

        // 로그인 안되어 있을 경우
        if (memberDto == null) {
            return "2";
        } else {
            lossService.replywrite(apikey, cano, rcontents, memberDto.getMno());
            return "1";
        }
    }
    // 댓글 삭제
    @GetMapping("/replydelete")
    @ResponseBody
    public int replydelete(@RequestParam("bno") int bno) {

        lossService.replydelete(bno);
        return 1;
    }

    // 댓글 수정
    @GetMapping("/replyupdate")
    @ResponseBody
    public String replyupdate(@RequestParam("bno") int bno, @RequestParam("newcontents") String newcontents){
        lossService.replyupdate(bno, newcontents);
        return "1";
    }
}