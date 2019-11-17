package com.algact.sort;

import com.starlc.util.Console;

/**
* @Description:    选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
* @Author:         liuc
* @CreateDate:     2019/11/17 17:33
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr, int n) {

    }

    @Override
    public void mySort(int[] arr, int n) {
        if (n<=1)return;
        for (int i = 0; i <n ; i++) {
            int min = arr[i];
            int minIndex = i;
            int j = i+1;
            for (; j <n ; j++) {
                //找到最小元素
                if (arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            Console.log("本次循环找到的最小值{0},其下标为{1}",min,minIndex);
            arr[minIndex] = arr[i];
            arr[i] = min;

        }
    }
}
