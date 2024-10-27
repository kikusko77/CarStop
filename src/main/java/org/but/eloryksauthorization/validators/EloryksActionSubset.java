package org.but.eloryksauthorization.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.but.eloryksauthorization.data.entity.enums.EloryksAction;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EloryksActionSubSetValidator.class)
public @interface EloryksActionSubset {
    EloryksAction[] anyOf();

    String message() default "must be any of {anyOf}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}