package com.simplezero.coding.sharding.repository.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 库存日志表
 * </p>
 *
 * @author simplezero
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("inv_inventory_log")
public class InvInventoryLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品表主键
     */
    private Long skuId;

    /**
     * 商品编码
     */
    private String skuCode;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 仓库表主键
     */
    private Long placeId;

    /**
     * 月份
     */
    private String month;


}
