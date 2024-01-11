package com.animousen4.game.engine.core.validate.chaining;

import com.animousen4.game.engine.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class PrettyValidationErrorChainingTest {




    @Mock
    ValidationError m;
    @Test
    void testParallelChainingOneOk() {

        int data = 0;

        List<ValidationError> errors = PrettyValidationErrorChaining.start()
                .go(() -> data, x -> Optional.empty())
                .parallel(
                        ch -> ch.go(() -> data, x -> Optional.empty())
                )
                .validate();

        assertTrue(errors.isEmpty());
    }

    @Test
    void testParallelChainingOneParallelFails() {

        int data = 0;

        List<ValidationError> errors = PrettyValidationErrorChaining.start()
                .go(() -> data, x -> Optional.empty())
                .parallel(
                        ch -> ch.go(() -> data, x -> Optional.of(m))
                )
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testParallelChainingAfterFirstGoFinishes() {

        int data = 0;

        List<ValidationError> errors = PrettyValidationErrorChaining.start()
                .go(() -> data, x -> Optional.of(m))
                .parallel(
                        ch -> ch.go(() -> data, x -> Optional.of(m))
                )
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testParallelChainingTwoParallelsWithFirstOk() {

        int data = 0;

        List<ValidationError> errors = PrettyValidationErrorChaining.start()
                .go(() -> data, x -> Optional.empty())
                .go(() -> data, x -> Optional.of(m))
                .parallel(
                        ch -> ch.go(() -> data, x -> Optional.of(m))
                )
                .parallel(
                        ch -> ch.go(() -> data, x -> Optional.of(m))
                )
                .validate();

        assertEquals(1, errors.size());
    }

    @Test
    void testChainingAllOkByCarExample() {
        Car car = new Car(
                "Tesla",
                "Model X",
                new Engine(
                        "ElectroV5",
                        4L,
                        new ElementMaterial(
                                "metall",
                                4
                        )
                )
        );

        List<ValidationError> errors = validateCar(car);

        assertEquals(0, errors.size());
    }

    @Test
    void testChainingFailByCarExample() {

        Car car = new Car(
                "Tesla",
                "Model X",
                new Engine(
                        null,
                        4L,
                        new ElementMaterial(
                                "metall",
                                4
                        )
                )
        );

        List<ValidationError> errors = validateCar(car);

        assertEquals(1, errors.size());
    }

    @Test
    void testChainingFailInsideEngineSubElementByCarExample() {

        Car car = new Car(
                "Tesla",
                "Model X",
                new Engine(
                        null,
                        4L,
                        new ElementMaterial(
                                null,
                                null
                        )
                )
        );

        List<ValidationError> errors = validateCar(car);

        assertEquals(3, errors.size());
    }
    @Test
    void testChainingFailInsideEngineByCarExample() {

        Car car = new Car(
                "Tesla",
                "Model X",
                null
        );

        List<ValidationError> errors = validateCar(car);

        assertEquals(1, errors.size());
    }




    List<ValidationError> validateCar(Car car) {
        return PrettyValidationErrorChaining.start()
                .go(
                        () -> car,
                        x -> getErrorIfEmpty(car, "car")
                )
                .parallel(
                        carV -> carV.go(
                                car::getManufacturer,
                                x->getErrorIfEmpty(x, "manufacturer")
                        )
                )
                .parallel(
                        carV -> carV.go(
                                car::getModel,
                                x->getErrorIfEmpty(x, "model")
                        )
                )
                .parallel(
                        carV -> carV.go(
                                        car::getEngine,
                                        x->getErrorIfEmpty(x, "engine")
                                )
                                .parallel(
                                        engineV -> engineV.go(
                                                () -> car.getEngine().getName(),
                                                x->getErrorIfEmpty(x, "name")
                                        )
                                )
                                .parallel(
                                        engineV -> engineV.go(
                                                () -> car.getEngine().getCapacity(),
                                                x->getErrorIfEmpty(x, "capacity")
                                        )
                                )
                                .parallel(
                                        engineV -> engineV.go(
                                                () -> car.getEngine().getElementMaterial(),
                                                x->getErrorIfEmpty(x, "elementMaterial")
                                        )
                                                .parallel(
                                                        materialV -> materialV.go(
                                                                ()-> car.getEngine().getElementMaterial().getId(),
                                                                x->getErrorIfEmpty(x, "id")
                                                        )
                                                )
                                                .parallel(
                                                        materialV -> materialV.go(
                                                                ()-> car.getEngine().getElementMaterial().getName(),
                                                                x->getErrorIfEmpty(x, "name")
                                                        )
                                                )
                                )
                )
                .validate();
    }
    Optional<ValidationError> getErrorIfEmpty(Object object, String fieldName) {
        return object == null
                ? Optional.of(new ValidationError(
                        "MANDATORY_FIELD_MISSING",
                                 "Field '%s' is missing".formatted(fieldName))
                )
                : Optional.empty();
    }

}
