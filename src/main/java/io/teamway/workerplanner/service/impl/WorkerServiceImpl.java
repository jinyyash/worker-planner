package io.teamway.workerplanner.service.impl;

import io.teamway.workerplanner.model.Worker;
import io.teamway.workerplanner.repository.WorkerRepository;
import io.teamway.workerplanner.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker updateWorker(Worker worker, Long id) {
        Optional<Worker> oldWorker = workerRepository.findById(id);
        if (oldWorker.isPresent()) {
            worker.setId(id);
            workerRepository.save(worker);
            return worker;
        }
        return null;
    }

    @Override
    public boolean deleteWorker(Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (!worker.isPresent()) {
            workerRepository.delete(worker.get());
            return true;
        }
        return false;
    }
}
