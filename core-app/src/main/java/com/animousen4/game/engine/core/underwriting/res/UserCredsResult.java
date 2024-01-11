package com.animousen4.game.engine.core.underwriting.res;

import com.animousen4.game.engine.core.services.dto.UserInfoDto;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserCredsResult {
    UserInfoDto userCreds;
    List<ValidationError> errorList;

    public boolean hasErrors() {
        return errorList != null;
    }
}
