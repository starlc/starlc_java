package com.algact.leetcode;

import java.util.HashMap;
import java.util.Map;
/**
* @Description:    求俩数之和为target的数值下标，下标不可用重复
* @Author:         liuc
* @CreateDate:     2019/11/27 16:04
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] rev = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                rev[0] = (int)map.get(nums[i]);
                rev[1] = i;
                break;
            }
            map.put(target-nums[i],i); //7,0
        }
        return rev;
    }
}
