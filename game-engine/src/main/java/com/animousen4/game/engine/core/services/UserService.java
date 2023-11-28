package com.animousen4.game.engine.core.services;

import com.animousen4.game.engine.core.services.dto.UserCreds;
import com.animousen4.game.engine.core.underwriting.res.UserCredsResult;
import com.animousen4.game.engine.dto.User;
import com.animousen4.game.engine.dto.v1.CreateOrUpdateUserResponseV1;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {

    UserCredsResult getUserCreds(User user);
}
