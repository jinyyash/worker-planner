package io.teamway.workerplanner.service.validation;

import io.teamway.workerplanner.model.Shift;
import io.teamway.workerplanner.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Set;

/**
 * validate worker has shift on given date
 */
@Component
public class WorkerShiftValidator {

    @Autowired
    private ShiftRepository shiftRepository;

    public void validate(Shift shift, Errors errors) {
        Set<Shift> shifts = shiftRepository.findShiftForGivenWorkerAndDate(shift.getWorker().getId(), shift.getDate());
        if (!shifts.isEmpty()) {
            errors.reject("You cannot add multiple shift for same worker in same day");
        }
    }
}
