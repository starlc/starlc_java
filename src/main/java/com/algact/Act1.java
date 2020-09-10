package com.algact;

import com.starlc.util.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Author: liuc
 * @CreateDate: 2019/11/14 14:15
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Act1 {
    /**
     * 时间复杂度为O(n^2)
     * 有没有好一点的算法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int count = 0 ;
        int[] result = new int[2];
        for(int m=0;m<nums.length-1;m++){
            //if(nums[m]>target) continue;
            for(int n=m+1;n<=nums.length-1;n++){
                count++;
                if(nums[m]+nums[n]==target){
                    result[0]=m;
                    result[1]=n;
                    break;
                }
            }
        }
        Console.log("执行次数{0}",count);
        return result;
    }

    /**
     * 整数数组 & 不能重复利用这个数组中同样的元素
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBYHashMap(int[] nums, int target) {
        int[] result = new int[2];
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int j = 0; j < nums.length; j++) {
            int need = target - nums[j];
            if (map.get(need)!=null && (int) map.get(need)!=j){
                result[0]=j;
                result[1]=(int)map.get(need);
                break;
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5}; int target = -8;
        Act1 act = new Act1();
        printArray(act.twoSum(nums,target));
        printArray(act.twoSumBYHashMap(nums,target));
    }

    public  static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}
