package com.simplezero.coding.sharding.repository.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Description:
 * @Author: simplezero
 * @Date: 2022/2/26 下午6:23
 */
public class ConsistentShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private ConsistentHashAlgorithm consistentHashAlgorithm;

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        if (consistentHashAlgorithm == null) {
            consistentHashAlgorithm = new ConsistentHashAlgorithm(collection);
        }
        return consistentHashAlgorithm.getTableNode(String.valueOf(preciseShardingValue.getValue()));
    }
}
