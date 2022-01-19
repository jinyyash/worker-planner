package io.teamway.workerplanner.service;

import io.teamway.workerplanner.model.Shift;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.util.Set;

public interface ShiftService {

    /**
     * Add new Shift to worker
     *
     * @param shift  shift
     * @param errors validation parameter to check new shift
     * @return
     */
    Shift addShift(Shift shift, Errors errors);

    /**
     * find shift for given worker and date
     *
     * @param id   worker id
     * @param date date need to be search
     * @return list of shifts for given worker id and date
     */
    Set<Shift> findShiftForGivenWorkerAndDate(Long id, LocalDate date);
}
