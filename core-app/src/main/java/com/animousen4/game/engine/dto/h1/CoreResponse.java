package com.animousen4.game.engine.dto.h1;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CoreResponse implements Serializable {
    List<ValidationError> errors;

}
