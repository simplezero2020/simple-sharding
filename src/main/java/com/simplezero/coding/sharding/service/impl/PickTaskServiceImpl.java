package com.simplezero.coding.sharding.service.impl;

import com.simplezero.coding.sharding.repository.bean.PickTask;
import com.simplezero.coding.sharding.repository.dao.PickTaskMapper;
import com.simplezero.coding.sharding.service.PickTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 分拣任务 服务实现类
 * </p>
 *
 * @author simplezero
 * @since 2022-02-15
 */
@Service
public class PickTaskServiceImpl extends ServiceImpl<PickTaskMapper, PickTask> implements PickTaskService {

}
