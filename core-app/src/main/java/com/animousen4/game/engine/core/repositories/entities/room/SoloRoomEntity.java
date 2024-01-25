package com.animousen4.game.engine.core.repositories.entities.room;

import com.animousen4.game.engine.core.repositories.entities.game.opponent.SoloGameOpponent;
import com.animousen4.game.engine.core.repositories.entities.game.type.GameTypePreference;
import com.animousen4.game.engine.core.api.model.game.PlayerColorModel;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("solo_room")
@Getter
public class SoloRoomEntity {
    @Id
    private String roomCode;

    private GameTypePreference gameTypePreference;
    private PlayerColorModel preferredColor;
    private SoloGameOpponent gameOpponent;

}
