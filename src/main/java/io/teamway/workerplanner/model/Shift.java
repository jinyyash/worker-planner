package io.teamway.workerplanner.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "worker_shift",
            joinColumns = @JoinColumn(name = "worker"),
            inverseJoinColumns = @JoinColumn(name = "shift")
    )
    @JsonIgnoreProperties("shifts")
    private Worker worker;

    public Shift(Long id, LocalDate date, LocalTime startTime, Worker worker) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.worker = worker;
    }

    public Shift() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
