package com.foug.product.ip.controller;

import com.foug.product.ip.entity.Worker;
import com.foug.product.ip.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 冯知帅
 * @since 2024/12/27 16:16
 */
@RestController
@RequestMapping("worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public List<Worker> findList() {
        return workerService.findList();
    }

    @PostMapping
    public void insert(@RequestBody Worker worker) {
        workerService.insert(worker);
    }

    @PutMapping
    public void update(@RequestBody Worker worker) {
        workerService.update(worker);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        workerService.delete(id);
    }

    @PutMapping("/enable/{id}")
    public void enable(@PathVariable String id) {
        workerService.enable(id);
    }

    @PutMapping("/disable/{id}")
    public void disable(@PathVariable String id) {
        workerService.disable(id);
    }
}
