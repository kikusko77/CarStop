package org.but.eloryksauthorization.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.but.eloryksauthorization.data.entity.enums.AuthorizedToSpeedLimitTargetVehicle;

import java.util.Arrays;

public class AuthorizedToSpeedLimitTargetVehicleSubsetValidator
        implements ConstraintValidator<AuthorizedToSpeedLimitTargetVehicleSubset, AuthorizedToSpeedLimitTargetVehicle> {
    private AuthorizedToSpeedLimitTargetVehicle[] subset;

    @Override
    public void initialize(AuthorizedToSpeedLimitTargetVehicleSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(AuthorizedToSpeedLimitTargetVehicle value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
