package com.animousen4.game.engine.websocket;

import com.animousen4.game.engine.dto.websocket.v1.GameAction;
import com.animousen4.game.engine.dto.websocket.v1.GameActionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GameWebSocketController {


    @MessageMapping("/chat")
    @SendTo("topic/messages")
    public GameActionResponse s(GameAction gameAction) {
        return new GameActionResponse("OK");
    }

}
