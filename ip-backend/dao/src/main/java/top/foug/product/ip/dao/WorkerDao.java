package top.foug.product.ip.dao;


import top.foug.product.ip.common.entity.Worker;

import java.util.List;

/**
 * @author 冯知帅
 * @since 2024/12/27 16:24
 */
public interface WorkerDao {
    Worker findById(String id);

    void deleteById(String id);

    void update(Worker worker);

    void insert(Worker worker);

    List<Worker> findList();

}
