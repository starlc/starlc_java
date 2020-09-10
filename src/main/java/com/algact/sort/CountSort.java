package com.algact.sort;

/**
 * @Description: 计数排序
 * 计数排序其实是桶排序的一种特殊情况。当要排序的 n 个数据，所处的范围并不大的时候，
 * 比如最大值是 k，我们就可以把数据划分成 k 个桶。每个桶内的数据值都是相同的，省掉了
 * 桶内排序的时间。
 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不
 * 适合用计数排序了。而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要
 * 将其在不改变相对大小的情况下，转化为非负整数。
 * @Author: liuc
 * @CreateDate: 2019/11/19 9:22
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CountSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {

    }

    @Override
    public void mySort(int[] arr, int n) {

    }
}
