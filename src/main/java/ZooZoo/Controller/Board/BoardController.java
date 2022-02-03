package ZooZoo.Controller.Board;

import ZooZoo.Domain.DTO.Board.LossDTO;
import ZooZoo.Service.Share.ShareService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class BoardController {
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
    public String goToLossBoardList() {

        LossDTO lossDTO = new LossDTO();
        ArrayList<LossDTO> lossDTOS = new ArrayList<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 110; i++) {

        }


        return "Board/Loss/LossBoardlist";
    }

    // 상세페이지로
    @GetMapping("/Board/Loss/LossBoardView")
    public String goToLossBoardView() {
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
