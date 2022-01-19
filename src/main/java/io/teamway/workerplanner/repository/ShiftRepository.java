package io.teamway.workerplanner.repository;

import io.teamway.workerplanner.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Set;

public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query("select s from Shift s join s.worker w where w.id= :id and s.date= :date")
    Set<Shift> findShiftForGivenWorkerAndDate(@Param("id") Long worker_id, @Param("date") LocalDate date);
}
