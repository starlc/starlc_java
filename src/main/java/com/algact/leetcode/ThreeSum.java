package com.algact.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Author: liuc
 * @CreateDate: 2019/11/26 17:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreeSum {

    /**
     * 自己解题失败，主要原因是无法去重
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //求三数之和，可先确定一个值，然后就变成了求俩数之和
        //第一版题目理错了，以为还是找下标
        List<List<Integer>> rev = new ArrayList<>();
        //确定一个元素，然后去找俩数之和为该值的俩个元素
        //关键是怎么去重
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i];
            int l = 0, r = nums.length - 1;
            //当l=r时已经遍历完数组
            //什么时候L++ 什么时候R--
            // l 和 r r先动，到了r=i的时候 l++ 然后 r重新开始
            while (l < r) {
                if (l == i) break;
                if (r == i) {
                    l++;
                    r = nums.length - 1;
                }
                if (r > i && nums[l] + nums[i] + nums[r] != 0) {
                    r--;
                    continue;
                }

                if (nums[l] + nums[i] + nums[r] == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[l]);
                    lst.add(nums[i]);
                    lst.add(nums[r]);
                    rev.add(lst);
                    break;
                }
            }
        }
        return rev;
    }

    /**
     * 看了思路题解，关键在于怎么去重，要想去重最好的办法就是先进行排序
     * 排序完成后[-4,-1, -1, 0, 1, 2 ]，
     * -1 0 1
     * -1 -1 2
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> rev = new ArrayList<>();
        if (nums.length < 3) {
            return rev;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            //i在最左侧，如果nums[i]>0 三数之和肯定>0 可结束当前循环
            if (nums[i] > 0) {
                break;
            }
            //去重，i-1 时，如果相邻俩个数相同，说明该组合数据已经计算过了，跳过当前循环直接下一次
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (l < r) {
                int result = nums[l] + nums[i] + nums[r];

                if (result == 0) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[l]);
                    lst.add(nums[r]);
                    rev.add(lst);
                    //l 和 l+1 的值相等，则下一次认为重复计算 并且 l<r（如果l<length-2 则说明lr可能相遇过了）
                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    //同理 r 和 r-1的值相等，当r-1时数据仍为重复计算
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }
                    l++;
                    r--;
                } else if (result > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return rev;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};//{0, 0, 0};
        List<List<Integer>> lst = threeSum1(arr);
        System.out.println(lst);
    }

}
