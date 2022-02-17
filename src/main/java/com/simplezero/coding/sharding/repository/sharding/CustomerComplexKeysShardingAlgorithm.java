package com.simplezero.coding.sharding.repository.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class CustomerComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    /**
     * 月份
     */
    private static final String COLUMN_MONTH = "month";
    /**
     * 地点
     */
    private static final String COLUMN_PLACE_ID = "place_id";

    @Override
    public Collection<String> doSharding(Collection availableTargetNames, ComplexKeysShardingValue shardingValue) {
        List<String> tableNameList = new ArrayList<>();
        //逻辑表名
        String logicTableName = shardingValue.getLogicTableName();
        Collection<String> monthCollection =
                (Collection<String>) shardingValue.getColumnNameAndShardingValuesMap().get(COLUMN_MONTH);
        Collection<Long> placeIdCollection =
                (Collection<Long>) shardingValue.getColumnNameAndShardingValuesMap().get(COLUMN_PLACE_ID);
        for (String originalMonth : monthCollection) {
            for (Long placeId : placeIdCollection) {
                String tableName = logicTableName + "_" + originalMonth + "_" + (placeId / 2 % 128);
                tableNameList.add(tableName);
            }
        }
        return tableNameList;
    }
}
