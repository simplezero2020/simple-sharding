package com.simplezero.coding.sharding.service.impl;

import com.simplezero.coding.sharding.repository.bean.RetryBizRecord;
import com.simplezero.coding.sharding.repository.dao.RetryBizRecordMapper;
import com.simplezero.coding.sharding.service.RetryBizRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 重试记录表 服务实现类
 * </p>
 *
 * @author simplezero
 * @since 2022-02-17
 */
@Service
public class RetryBizRecordServiceImpl extends ServiceImpl<RetryBizRecordMapper, RetryBizRecord> implements RetryBizRecordService {

}
