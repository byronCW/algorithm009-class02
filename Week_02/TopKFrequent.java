package com.gkb.algorithm;

import java.util.*;

/**
 * @author Byron Wang
 * @desc Top K 频率的数
 * @date 2020/5/31
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // 利用 hash 表存储数字出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        // 构建小顶堆（即出现频率从堆顶向下依次减少），存储 k 个元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue((n1, n2) -> countMap.get(n1) - countMap.get(n2));

        for (int num : countMap.keySet()) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                // 元素超过 k 个，将出现次数最少的即堆顶元素移除
                priorityQueue.poll();
            }
        }

        int[] res = new int[k];
        //int index = k - 1;
        while (!priorityQueue.isEmpty()) {
            res[k - 1] = priorityQueue.poll();
            k--;
        }
        return res;
    }
}
