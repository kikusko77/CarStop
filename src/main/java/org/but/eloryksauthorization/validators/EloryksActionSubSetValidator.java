package org.but.eloryksauthorization.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.but.eloryksauthorization.data.entity.enums.EloryksAction;

import java.util.Arrays;

public class EloryksActionSubSetValidator implements ConstraintValidator<EloryksActionSubset, EloryksAction> {
    private EloryksAction[] subset;

    @Override
    public void initialize(EloryksActionSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(EloryksAction value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}