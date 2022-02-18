package com.simplezero.coding.sharding.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.simplezero.coding.sharding.BaseTest;
import com.simplezero.coding.sharding.repository.bean.InvInventoryLog;
import com.simplezero.coding.sharding.repository.bean.OperationLog;
import com.simplezero.coding.sharding.repository.bean.PickTask;
import com.simplezero.coding.sharding.repository.bean.RetryBizRecord;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Description:
 * @Author: simplezero
 * @Date: 2022/2/15 10:20 下午
 */
public class ShardingJdbcTest extends BaseTest {

    public static String pattern0 = "yyyy-MM-dd HH:mm:ss";

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
        //支持 IN
        pickTaskService.list(new QueryWrapper<PickTask>().lambda()
                .in(PickTask::getPlaceId, Lists.newArrayList(1, 2)));
    }

    @Test
    public void testPreciseSharding() {
        //bizId = 1 ==> ds_(1%2) ==> ds1
        //sharding_key = 2022_101  ==> retry_biz_record_(2022_101%4) = retry_biz_record_2022_1
        retryBizRecordService.list(new QueryWrapper<RetryBizRecord>().lambda()
                .eq(RetryBizRecord::getBizId, 1)
                .eq(RetryBizRecord::getShardingKey, "202202_101"));
    }


    @Test
    public void testRangeSharding() {
        //PreciseShardingAlgorithm = IN
        operationLogService.list(new QueryWrapper<OperationLog>().lambda()
                .eq(OperationLog::getCreateTime, new Date()));

        //RangeShardingAlgorithm <> BETWEEN AND
        Date start = DateUtil.parse("2022-01-01 12:00:00", pattern0);
        Date end = DateUtil.parse("2022-03-01 12:00:00", pattern0);
        operationLogService.list(new QueryWrapper<OperationLog>().lambda()
                .ge(OperationLog::getCreateTime, start)
                .le(OperationLog::getCreateTime, end));
    }

    @Test
    public void testComplexKeysSharding() {
        invInventoryLogService.list(new QueryWrapper<InvInventoryLog>().lambda()
                .eq(InvInventoryLog::getPlaceId, 2L)
                .eq(InvInventoryLog::getMonth, "2021_10"));
    }

}