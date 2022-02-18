package com.simplezero.coding.sharding.repository.sharding;

import cn.hutool.core.date.DateUtil;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Date;

public class MonthlyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> preciseShardingValue) {
        String month = DateUtil.format(preciseShardingValue.getValue(), "yyyyMM");
        return preciseShardingValue.getLogicTableName() + "_" + month;
    }
}
