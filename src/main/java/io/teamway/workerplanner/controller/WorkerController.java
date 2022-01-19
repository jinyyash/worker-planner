package io.teamway.workerplanner.controller;


import io.teamway.workerplanner.model.Worker;
import io.teamway.workerplanner.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("api/v1")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/workers")
    public List<Worker> getWorkers() {
        return workerService.getWorkers();
    }

    @PostMapping("/worker")
    public Worker addWorker(@RequestBody Worker worker) {
        return workerService.addWorker(worker);
    }

    @PutMapping("/worker/{id}")
    public ResponseEntity<?> updateWorker(@RequestBody Worker worker, @PathVariable Long id) {
        if (nonNull(workerService.updateWorker(worker, id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/worker/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable Long id) {
        return workerService.deleteWorker(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
