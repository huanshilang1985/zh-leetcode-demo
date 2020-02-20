package com.zh.algorithm;

import com.alibaba.fastjson.JSON;
import netscape.javascript.JSObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 算法题1：两数之和
 * 描述：
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author he.zhang
 * @date 2020/2/20 15:11
 */
public class question1_sum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            // 如果判断nums[i] 在map里存在，说明之前已经作为补数存过了，可直接提取结果
            if(map.containsKey(nums[i])){
                // 结果是当前循环的i，和补数map.get(nums[i])
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
            // key是补数（target-数组值=差）, value是位置
            map.put(target - nums[i], i);
        }
        // 因为数组下面可能会因为补数倒置了顺序，所以输出之前把数组排序
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 6, 11, 15};
        int target = 12;
        int[] ints = question1_sum.twoSum(nums, target);
        System.out.println("计算结果：" + JSON.toJSONString(ints));
    }

}
