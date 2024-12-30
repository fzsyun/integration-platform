package com.foug.product.ip.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.foug.product.ip.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 冯知帅
 * @since 2024/12/27 16:25
 */
@Component
public class DefaultWorkerDao implements WorkerDao {

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public Worker findById(String id) {
        return workerMapper.selectById(id);
    }

    @Override
    public void deleteById(String id) {
        workerMapper.deleteById(id);
    }

    @Override
    public void update(Worker worker) {
        workerMapper.updateById(worker);
    }

    @Override
    public void insert(Worker worker) {
        workerMapper.insert(worker);
    }

    @Override
    public List<Worker> findList() {
        return workerMapper.selectList(new LambdaQueryWrapper<>());
    }
}
