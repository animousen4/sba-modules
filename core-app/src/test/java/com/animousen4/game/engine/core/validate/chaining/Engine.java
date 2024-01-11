package com.animousen4.game.engine.core.validate.chaining;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Engine{
    final String name;
    final Long capacity;
    final ElementMaterial elementMaterial;
}