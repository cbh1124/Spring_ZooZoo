package ZooZoo.Chatting;

import ZooZoo.Domain.DTO.Member.MemberDTO;
import ZooZoo.Domain.Entity.Member.MemberEntity;
import ZooZoo.Domain.Entity.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    HttpServletRequest request;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/rooms")
    public String rooms(Model model){
        HttpSession session = request.getSession();
        MemberDTO memberDto = (MemberDTO) session.getAttribute("loginDTO");
        MemberEntity memberEntity = memberRepository.findById(memberDto.getMno()).get();


        if (memberDto != null){
            chatRoomRepository.createChatRoom(memberDto.getMno(),memberEntity.getMname());
        }
        model.addAttribute("loginDTO",memberDto);
        model.addAttribute("rooms",chatRoomRepository.findAllRoom());
        return "rooms";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable int id, Model model){
        ChatRoom room = chatRoomRepository.findRoomById(id);
        model.addAttribute("room",room);
        return "room";
    }

//    // 방만들기
//    @GetMapping("/new")
//    public String make(Model model){
//        ChatRoomForm form = new ChatRoomForm();
//        model.addAttribute("form",form);
//        return "newRoom";
//    }
//
//    @PostMapping("/room/new")
//    public String makeRoom(ChatRoomForm form){
//        chatRoomRepository.createChatRoom(form.getName());
//
//        return "rooms";
//    }

}
