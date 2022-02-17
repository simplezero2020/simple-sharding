package com.simplezero.coding.sharding.repository.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author simplezero
 * @since 2022-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("operation_log")
public class OperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    private String userPhone;

    /**
     * 用户账号4位后缀
     */
    private String userPhoneSuffix;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 月份
     */
    private String month;


}
