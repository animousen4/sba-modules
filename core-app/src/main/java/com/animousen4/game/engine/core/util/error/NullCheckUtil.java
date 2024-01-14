package com.animousen4.game.engine.core.util.error;

import com.animousen4.game.engine.core.util.Placeholder;
import com.animousen4.game.engine.core.validate.ValidationErrorFactory;
import com.animousen4.game.engine.dto.h1.ValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.animousen4.game.engine.core.values.AppConsts.FIELD_NAME;
import static com.animousen4.game.engine.core.values.AppConsts.MANDATORY_FIELD_MISSING;

@Component
@RequiredArgsConstructor
public class NullCheckUtil {

    private final ValidationErrorFactory validationErrorFactory;
    public <T> Optional<ValidationError> checkForNull(T object, String name) {
        if (object == null)
            return Optional.of(
                    validationErrorFactory.buildError(
                            MANDATORY_FIELD_MISSING,
                            new Placeholder(
                                    FIELD_NAME,
                                    name
                            )
                    )
            );
        return Optional.empty();
    }
}
