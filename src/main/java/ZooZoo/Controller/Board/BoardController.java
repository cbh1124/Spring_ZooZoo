package ZooZoo.Controller.Board;

import ZooZoo.Domain.DTO.Board.LossDTO;
import ZooZoo.Service.Loss.LossService;
import ZooZoo.Service.Share.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BoardController {

    @Autowired
    LossService lossService;

    // 분양게시판으로
    @GetMapping("/ShareBoardList")
    public String goToShareBoardList() {
        ShareService shareService = new ShareService();
        shareService.Share();
        return "Board/Share/ShareBoardList";
    }

    // 자유게시판으로
    @GetMapping("/freeboard")
    public String GotoFreeBoard() {
        return "Board/Free/FreeBoardMain";
    }


    // 유기게시판으로
    @GetMapping("/LossBoardlist")
    public String goToLossBoardList(Model model) {

        ArrayList<LossDTO> lossDTOS = lossService.Losslist();
        model.addAttribute("lossDTOS",lossDTOS);
        return "Board/Loss/LossBoardlist";
    }

    // 상세페이지로
    @GetMapping("/Board/Loss/LossBoardView/{ABDM_IDNTFY_NO}")
    public String goToLossBoardView(Model model, @PathVariable("ABDM_IDNTFY_NO") String ABDM_IDNTFY_NO) {
        ArrayList<LossDTO> lossDTOS = lossService.getlossboard(ABDM_IDNTFY_NO);
        model.addAttribute("lossDTOS",lossDTOS);
        return "Board/Loss/LossBoardView";
    }

    @GetMapping("/Board/Share/ShareBoardView")
    public String goToShareBoardView() {
        return "Board/Share/ShareBoardView";
    }

    @GetMapping("/Board/Free/FreeBoardView")
    public String goToFreeBoardView() {
        return "Board/Free/FreeBoardView";
    }
    // d33e0915e37c453abb4d9a94d8f265ed
}
