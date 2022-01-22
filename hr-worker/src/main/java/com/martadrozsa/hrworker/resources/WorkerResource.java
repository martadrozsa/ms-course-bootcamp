package com.martadrozsa.hrworker.resources;

import com.martadrozsa.hrworker.entities.Worker;
import com.martadrozsa.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
@AllArgsConstructor
public class WorkerResource {

    private WorkerRepository workerRepository;

    @GetMapping
    private ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = workerRepository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Worker> findById(@PathVariable Long id) {
        Worker obj = workerRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
