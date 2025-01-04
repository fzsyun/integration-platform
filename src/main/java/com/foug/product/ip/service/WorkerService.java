package com.foug.product.ip.service;

import com.foug.product.ip.entity.Worker;

import java.util.List;

/**
 * @author 冯知帅
 * @since 2024/12/27 16:22
 */
public interface WorkerService {
    List<Worker> findList();

    void insert(Worker worker);

    void update(Worker worker);

    void delete(String id);

    void enable(String id);

    void disable(String id);

}
