package top.foug.product.ip.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 冯知帅
 * @since 2024/12/27 16:17
 */
@Data
@Accessors(chain = true)
public class Worker {

    public enum RunningStatus {
        ENABLE, DISABLE
    }

    @TableId
    private String id;

    private String name;

    private String projectId;

    private String projectName;

    private String context;

    private RunningStatus status;
}
