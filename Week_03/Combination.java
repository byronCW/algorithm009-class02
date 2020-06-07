package com.gkb.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Byron Wang
 * @desc 1-n整数中找到所有k 个数的组合
 * @date 2020/6/7
 */
public class Combination {

    List<List<Integer>> res = new LinkedList();

    public void backtrack(int first, ArrayList<Integer> curr,int n, int k) {
        // terminator
        if (curr.size() == k)
            res.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, curr, n, k);
            // reverse status
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, new ArrayList<Integer>(k), n, k);
        return res;
    }

}
