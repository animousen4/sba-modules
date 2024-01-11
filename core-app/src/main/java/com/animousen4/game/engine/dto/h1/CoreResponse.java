package com.animousen4.game.engine.dto.h1;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CoreResponse {
    List<ValidationError> errors;

}
