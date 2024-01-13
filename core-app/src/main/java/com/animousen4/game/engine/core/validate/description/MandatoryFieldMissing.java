package com.animousen4.game.engine.core.validate.description;

import com.animousen4.game.engine.core.util.Placeholder;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.animousen4.game.engine.core.values.AppConsts.FIELD_NAME;
import static com.animousen4.game.engine.core.values.AppConsts.MANDATORY_FIELD_MISSING;

public class MandatoryFieldMissing extends ErrorPair{

    private MandatoryFieldMissing(List<Placeholder> placeholderList) {
        super(placeholderList);
    }

    static MandatoryFieldMissing of(String fieldName) {
        return new MandatoryFieldMissing(List.of(
                new Placeholder(FIELD_NAME, fieldName)
        ));
    }

    @Override
    public String getErrorCode() {
        return MANDATORY_FIELD_MISSING;
    }

}
