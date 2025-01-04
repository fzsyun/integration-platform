package com.foug.product.ip.service;

import cn.hutool.core.codec.Base64Decoder;
import com.foug.product.ip.dao.WorkerDao;
import com.foug.product.ip.entity.Worker;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

/**
 * @author 冯知帅
 * @since 2024/12/27 16:22
 */
@Service
public class DefaultWorkerService implements WorkerService {

    @Autowired
    private WorkerDao workerDao;

    @Autowired
    private CamelContextService camelContextService;

    @Override
    public List<Worker> findList() {
        return workerDao.findList();
    }

    @Override
    public void insert(Worker worker) {
        workerDao.insert(worker);
    }

    @Override
    public void update(Worker worker) {
        workerDao.update(worker);
    }

    @Override
    public void delete(String id) {
        workerDao.deleteById(id);
    }

    @Override
    public void enable(String id) {
        Worker worker = workerDao.findById(id);
        String context = Base64Decoder.decodeStr(worker.getContext());
        camelContextService.enable(id, context);
        workerDao.update(worker.setStatus(Worker.RunningStatus.ENABLE));
    }

    @Override
    public void disable(String id) {
        Worker worker = workerDao.findById(id);
        camelContextService.disable("route-2395");
        workerDao.update(worker.setStatus(Worker.RunningStatus.DISABLE));
    }
}
