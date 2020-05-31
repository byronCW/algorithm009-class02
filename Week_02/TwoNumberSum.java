package com.gkb.algorithm;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Byron Wang
 * @desc 两数之和:在给定数组中找到两个数之和等于给定值，并返回两数下标
 * @date 2020/5/30
 */
public class TwoNumberSum {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test1() {
        int[] nums = {1, 5, 9, 3, 18, 50, 2};
        int[] res = twoSum(nums, 21);

        Assert.assertEquals(Arrays.toString(res), "[3, 4]");
    }

    @Test
    public void test2() {
        expectedException.expect(RuntimeException.class);

        int[] nums = {1, 5, 9, 3, 18, 50, 2};
        int[] res = twoSum(nums, 9);

        expectedException.expectMessage("no found two num in arr");
    }

    @Test
    public void test3() {
        int[] nums = {9, 3, 18, 50, 2, 3};
        int[] res = twoSum(nums, 6);

        Assert.assertEquals(Arrays.toString(res), "[1, 5]");
    }

    @Test
    public void test4() {
        int[] nums = {11, 50};
        int[] res = twoSum(nums, 61);

        Assert.assertEquals(Arrays.toString(res), "[0, 1]");
    }

    /**
     * 一遍 hash 法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[]{map.get(another), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("no found two num in arr");
    }
}
