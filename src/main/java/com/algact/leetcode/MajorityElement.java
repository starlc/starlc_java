package com.algact.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * @Author: liuc
 * @CreateDate: 2019/11/28 18:01
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MajorityElement {
    /**
     * 第一次解
     */
    public static int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int t = (int) map.get(nums[i]);
                map.put(nums[i], ++t);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0, rev = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                rev = key;
            }
        }
        return rev;
    }

    public static int majorityElement2(int[] nums) {
        int rev = 0;
        //
        return rev;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3};
        System.out.println(majorityElement(arr));
    }
}
