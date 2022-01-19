package io.teamway.workerplanner.service.validation;

import io.teamway.workerplanner.model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class Validator {

    @Autowired
    private StartTimeValidator startTimeValidator;
    @Autowired
    private WorkerShiftValidator workerShiftValidator;

    public void validate(Shift shift, Errors errors) {
        workerShiftValidator.validate(shift, errors);
        startTimeValidator.validate(shift, errors);
    }
}
