package com.wq.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <Description>
 *
 * @author wangqi
 * @version 1.0
 * @see com.wq.leetcode
 * @since 2020/09/23 16:15
 */
public class Junior39CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length <= 0) {
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> rs = new ArrayList<>();
        ArrayDeque q = new ArrayDeque();
        depth(candidates, target, rs, q, 0);
        return rs;
    }

    public static void depth(int[] candidates, int target, List<List<Integer>> rs, ArrayDeque q, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            rs.add(new ArrayList<>(q));
            return;
        }
        for (; start < candidates.length; start++) {
            q.addLast(candidates[start]);
            depth(candidates, target - candidates[start], rs, q, start);
            q.removeLast();
        }
    }

    public static void main(String[] args){
        combinationSum(new int[]{2,3,6,7},7);
    }
}
