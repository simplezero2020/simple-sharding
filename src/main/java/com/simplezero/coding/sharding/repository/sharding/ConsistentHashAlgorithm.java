package com.simplezero.coding.sharding.repository.sharding;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: simplezero
 * @Date: 2022/2/26 下午5:17
 */
@Slf4j
@Data
public class ConsistentHashAlgorithm {

    private SortedMap<Long, String> virtualNodes = new TreeMap<>();

    public ConsistentHashAlgorithm(Collection<String> tableNodes) {
        initNodesToHashLoop(tableNodes);
    }

    public void initNodesToHashLoop(Collection<String> tableNodes) {
        SortedMap<Long, String> virtualTableNodes = new TreeMap<>();
        for (String node : tableNodes) {
            long hash = getHash(node);
            virtualTableNodes.put(hash, node);
        }
        for (Map.Entry<Long, String> entry : virtualTableNodes.entrySet()) {
            log.info("节点[" + entry.getValue() + "]被添加, hash值为" + entry.getKey());
        }
        this.virtualNodes = virtualTableNodes;
    }

    public String getTableNode(String key) {
        SortedMap<Long, String> subMap = virtualNodes.tailMap(getHash(key));
        if (subMap.isEmpty()) {
            return virtualNodes.get(virtualNodes.firstKey());
        }
        return subMap.get(subMap.firstKey());
    }

    /**
     * 使用FNV1_32_HASH算法计算key的Hash值
     *
     * @param key
     * @return
     */
    public long getHash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
