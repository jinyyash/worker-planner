package io.teamway.workerplanner.controller;

import io.teamway.workerplanner.model.Shift;
import io.teamway.workerplanner.service.ShiftService;
import io.teamway.workerplanner.service.validation.StartTimeValidator;
import io.teamway.workerplanner.service.validation.WorkerShiftValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @PostMapping("/shift")
    public ResponseEntity<?> addShift(@RequestBody Shift shift, Errors errors) {
        shiftService.addShift(shift, errors);
        if (errors.hasErrors()) {
            return new ResponseEntity<>(createErrorString(errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findShiftByWorkerAndDate")
    public Set<Shift> getFindShiftForGivenWorkerAndDateWorker(@RequestParam("id") Long id, @RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return shiftService.findShiftForGivenWorkerAndDate(id, date);
    }

    private String createErrorString(Errors errors) {
        return errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getCode).collect(Collectors.joining(","));
    }
}
