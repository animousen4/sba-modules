package com.animousen4.game.engine.core.underwriting.res;

import com.animousen4.game.engine.core.services.dto.UserCreds;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserCredsResult {
    UserCreds userCreds;
    List<ValidationError> errorList;
}
