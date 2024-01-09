package com.animousen4.game.engine.core.validate;

import com.animousen4.game.engine.core.util.ErrorCodeUtil;
import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.dto.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationErrorFactory {
    @Autowired
    private ErrorCodeUtil errorCodeUtil;

    public ValidationError buildError(String errorCode) {
        String errorDescription = errorCodeUtil.getErrorDescription(errorCode);
        return new ValidationError(errorCode, errorDescription);
    }

    public ValidationError buildError(String errorCode, List<Placeholder> placeholders) {
        String errorDescription = errorCodeUtil.getErrorDescription(errorCode, placeholders);
        return new ValidationError(errorCode, errorDescription);
    }

    public ValidationError buildError(String errorCode, Placeholder placeholder) {
        return buildError(errorCode, List.of(placeholder));
    }
}
