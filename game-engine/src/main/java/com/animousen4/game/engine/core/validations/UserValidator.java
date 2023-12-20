package com.animousen4.game.engine.core.validations;

import com.animousen4.game.engine.core.services.dto.UserDto;
import com.animousen4.game.engine.dto.ValidationError;

import java.util.List;

public interface UserValidator {
    List<ValidationError> validate(UserDto user);
}
