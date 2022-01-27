package ZooZoo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/Board/Boardlist")
    public String Boardlist(){
        return "Board/Boardlist";
    }
    @GetMapping("/Board/Boardview")
    public String boardview(){
        return "Board/Boardview";
    }
}
