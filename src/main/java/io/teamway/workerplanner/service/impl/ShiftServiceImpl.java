package io.teamway.workerplanner.service.impl;

import io.teamway.workerplanner.model.Shift;
import io.teamway.workerplanner.repository.ShiftRepository;
import io.teamway.workerplanner.service.ShiftService;
import io.teamway.workerplanner.service.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Set;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private Validator validator;

    @Override
    public Shift addShift(Shift shift, Errors errors) {
        validator.validate(shift, errors);
        if (!errors.hasErrors()) {
            shiftRepository.save(shift);
        }
        return null;
    }

    @Override
    @Transactional
    public Set<Shift> findShiftForGivenWorkerAndDate(Long id, LocalDate date) {
        return shiftRepository.findShiftForGivenWorkerAndDate(id, date);
    }
}
