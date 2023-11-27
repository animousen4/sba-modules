package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.dto.User;
import com.animousen4.game.engine.dto.ValidationError;

import java.util.List;

public interface UserValidator {
    List<ValidationError> validate(User user);
}
