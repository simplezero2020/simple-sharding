package com.simplezero.coding.sharding.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.simplezero.coding.sharding.BaseTest;
import com.simplezero.coding.sharding.repository.bean.InvInventoryLog;
import com.simplezero.coding.sharding.repository.bean.OperationLog;
import com.simplezero.coding.sharding.repository.bean.PickTask;
import com.simplezero.coding.sharding.repository.bean.RetryBizRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: simplezero
 * @Date: 2022/2/15 10:20 下午
 */
public class ShardingJdbcTest extends BaseTest {


    @Autowired
    private PickTaskService pickTaskService;

    @Autowired
    private RetryBizRecordService retryBizRecordService;

    @Autowired
    private OperationLogService operationLogService;

    @Autowired
    private InvInventoryLogService invInventoryLogService;

    @Test
    public void testInlineSharding() {
        //不带分片键 查询所有物理表
        pickTaskService.list(new QueryWrapper<PickTask>().lambda()
                .eq(PickTask::getId, 1));
        //placeId = 1 ==> ds_(1%2).pick_task_(1/2%4) = ds1.pick_task_0
        pickTaskService.list(new QueryWrapper<PickTask>().lambda()
                .eq(PickTask::getPlaceId, 1));
    }

    @Test
    public void testPreciseSharding() {

        //不带分片键 查询所有物理表
        retryBizRecordService.list(new QueryWrapper<RetryBizRecord>().lambda()
                .eq(RetryBizRecord::getBizId, 1));

        //只有分表键 扫所有的库
        //sharding_key = 2022_101 = 1 ==> ds_(1%2).retry_biz_record_(2022_101%4) = ds1.retry_biz_record_2022_1
        retryBizRecordService.list(new QueryWrapper<RetryBizRecord>().lambda()
                .eq(RetryBizRecord::getShardingKey, "202202_101"));

        //placeid = 1 ==> ds_(1%2)
        //sharding_key = 2022_101  ==> retry_biz_record_(2022_101%4) = retry_biz_record_2022_1
        retryBizRecordService.list(new QueryWrapper<RetryBizRecord>().lambda()
                .eq(RetryBizRecord::getShardingKey, "202202_101"));

        //sharding_key = 2022_101  ==> retry_biz_record_(2022_101%4) = retry_biz_record_2022_1
        operationLogService.list(new QueryWrapper<OperationLog>().lambda()
                .eq(OperationLog::getMonth, "202202"));
    }


    @Test
    public void testComplexKeysSharding() {

        invInventoryLogService.list(new QueryWrapper<InvInventoryLog>().lambda()
                .eq(InvInventoryLog::getPlaceId,2L)
                .eq(InvInventoryLog::getMonth, "2021_10"));
    }

}