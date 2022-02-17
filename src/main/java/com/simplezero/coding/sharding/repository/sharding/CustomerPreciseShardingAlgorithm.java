package com.simplezero.coding.sharding.repository.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;


@Slf4j
public class CustomerPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    private static final String SEPARATOR = "_";

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        try {
            String[] keys = shardingValue.getValue().split(SEPARATOR);
            String date = keys[0];
            int bizType = Integer.parseInt(keys[1]);
            return shardingValue.getLogicTableName() + SEPARATOR + date + SEPARATOR + bizType % 4;
        } catch (Exception exception) {
            log.error("doSharding error，shardingValue:{},exception:{}", shardingValue.getValue(),
                    exception.toString(), exception);
            throw exception;
        }
    }
}
