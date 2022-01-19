package io.teamway.workerplanner.service;

import io.teamway.workerplanner.model.Worker;

import java.util.List;

public interface WorkerService {

    /**
     * get all workers
     *
     * @return list of workers
     */
    List<Worker> getWorkers();

    /**
     * Add new worker
     *
     * @param worker worker to be added
     * @return Worker
     */
    Worker addWorker(Worker worker);

    /**
     * update existing worker
     *
     * @param worker worker to be update
     * @param id     worker id
     * @return updated worker details
     */
    Worker updateWorker(Worker worker, Long id);

    /**
     * delete worker
     *
     * @param id worker id
     * @return worker delete status
     */
    boolean deleteWorker(Long id);

}
