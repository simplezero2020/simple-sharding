package com.simplezero.coding.sharding.repository.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 重试记录表
 * </p>
 *
 * @author simplezero
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("retry_biz_record")
public class RetryBizRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业务单据号
     */
    private String bizNo;

    /**
     * 业务id
     */
    private Long bizId;

    /**
     * 业务类型
     */
    private Integer bizType;

    private String shardingKey;


}
