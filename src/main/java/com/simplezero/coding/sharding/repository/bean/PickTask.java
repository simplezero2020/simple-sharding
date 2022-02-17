package com.simplezero.coding.sharding.repository.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分拣任务
 * </p>
 *
 * @author simplezero
 * @since 2022-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pick_task")
public class PickTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 仓库ID
     */
    private Long warehouseId;

    /**
     * 仓库编码
     */
    private String warehouseCode;

    /**
     * 目的流向ID
     */
    private Long placeId;

    /**
     * 目的流向编码
     */
    private String placeCode;

    /**
     * 销售商品ID
     */
    private Long itemId;


}
