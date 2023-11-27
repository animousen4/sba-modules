package com.animousen4.game.engine.dto.v1;

import com.animousen4.game.engine.dto.CoreResponse;
import com.animousen4.game.engine.dto.ValidationError;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CreateOrUpdateUserResponseV1 extends CoreResponse {

    String status;
    public CreateOrUpdateUserResponseV1(List<ValidationError> errors) {
        super(errors);
    }
}
