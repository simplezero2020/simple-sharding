package com.simplezero.coding.sharding.service.impl;

import com.simplezero.coding.sharding.repository.bean.OperationLog;
import com.simplezero.coding.sharding.repository.dao.OperationLogMapper;
import com.simplezero.coding.sharding.service.OperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author simplezero
 * @since 2022-02-17
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {

}
