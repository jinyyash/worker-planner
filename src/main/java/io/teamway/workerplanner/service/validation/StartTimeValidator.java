package io.teamway.workerplanner.service.validation;

import io.teamway.workerplanner.model.Shift;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * validate start time of shift
 */
@Component
public class StartTimeValidator {

    public void validate(Shift shift, Errors errors) {
        Set<LocalTime> times = Stream.of(LocalTime.of(0, 0), LocalTime.of(8, 0), LocalTime.of(16, 0)).collect(Collectors.toSet());
        if (!times.contains(shift.getStartTime())) {
            errors.reject("Start Time should be 0000,0800,1600");
        }
    }
}
