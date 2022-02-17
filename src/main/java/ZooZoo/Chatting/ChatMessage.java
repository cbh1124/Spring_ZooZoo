package ZooZoo.Chatting;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter @Setter
public class ChatMessage {
    private int chatRoomId;
    private String writer;
    private String message;
    private MessageType type;
}
