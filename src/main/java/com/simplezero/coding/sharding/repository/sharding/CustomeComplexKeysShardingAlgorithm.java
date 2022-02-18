package com.simplezero.coding.sharding.repository.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class CustomeComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        List<String> tableNameList = new ArrayList<>();
        String logicTableName = shardingValue.getLogicTableName();
        Collection<String> monthCollection =
                (Collection<String>) shardingValue.getColumnNameAndShardingValuesMap().get("month");
        Collection<Long> placeIdCollection =
                (Collection<Long>) shardingValue.getColumnNameAndShardingValuesMap().get("place_id");
        for (String originalMonth : monthCollection) {
            for (Long placeId : placeIdCollection) {
                String tableName = logicTableName + "_" + originalMonth + "_" + (placeId / 2 % 128);
                tableNameList.add(tableName);
            }
        }
        return tableNameList;
    }
}
