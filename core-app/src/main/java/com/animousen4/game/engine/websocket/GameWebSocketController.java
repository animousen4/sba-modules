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

/*
@Controller
public class GameWebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/secured/room")
    public void sendSpecific(
            @Payload GameAction msg,
            Principal user,
            @Header("simpSessionId") String sessionId) throws Exception {
        GameActionResponse out = new GameActionResponse("OK");
        simpMessagingTemplate.convertAndSendToUser(
                msg.getTo(), "/secured/user/queue/specific-user", out);
    }

}
*/
