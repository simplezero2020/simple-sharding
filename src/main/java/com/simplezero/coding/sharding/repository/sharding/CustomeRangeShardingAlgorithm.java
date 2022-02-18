package com.simplezero.coding.sharding.repository.sharding;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.assertj.core.util.Lists;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

public class CustomeRangeShardingAlgorithm implements RangeShardingAlgorithm<Date> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         RangeShardingValue<Date> shardingValue) {
        Collection<String> result = new LinkedHashSet<>();
        Range<Date> range = shardingValue.getValueRange();
        // 区间开始和结束值
        Date lower = range.lowerEndpoint();
        Date upper = range.upperEndpoint();
        List<String> monthList = this.getMonthListBetweenDate(lower, upper);
        for (String month : monthList) {
            result.add(shardingValue.getLogicTableName() + "_" + month);
        }
        return result;
    }

    private List<String> getMonthListBetweenDate(Date startDate, Date endDate) {
        List<String> result = Lists.newArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), 1);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), 2);
        while (start.before(end)) {
            result.add(simpleDateFormat.format(start.getTime()));
            start.add(Calendar.MONTH, 1);
        }
        return result;
    }

}