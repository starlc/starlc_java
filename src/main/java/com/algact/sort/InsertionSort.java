package com.algact.sort;

/**
* @Description:    插入排序
 * 一个有序的数组，我们往里面添加一个新的数据后，如何继续保持数据有序呢？
 * 很简单，我们只要遍历数组，找到数据应该插入的位置将其插入即可。
 *
 * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。插入算法的核心思想是取未排序区间中的元素，
 * 在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未
 * 排序区间中元素为空，算法结束。
* @Author:         liuc
* @CreateDate:     2019/11/17 17:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class InsertionSort implements Sort {
    /**
     * 标准实现
     * 原地排序 稳定排序
     * 时间复杂度分析O(n^2) 空间复杂度 O(1)
     * @param a 要排序的数组
     * @param n 数字的大小
     */
    @Override
    public void sort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    /**
     * 第一次实现的思路 就是从第1个元素开始 取值一次和 前面有序的数组中的每个数据进行比较
     * 发现数据比被比较数据小 则将有序书中的后半部分依次后移，再插入该数据 实现起来代码会比较复杂
     * @param arr
     * @param n
     */
    @Override
    public void mySort(int[] arr, int n) {
        if (n<=1)return;
        for (int i = 1; i < n; i++) {
            //每次拿第i个元素 去和i之前的元素进行比较，
            int tmp = arr[i];
            //原有思路是拿第 i个元素 和 0~i-1之间的数据去比较，发现 i比任意值小 则插入进去
            //可以优化一下，就是每次直接和最后一个数比较，如果小就交换位置,否则结束当前循环
            int j = i-1;
            for (; j >=0 ; j--) {
                if (tmp<arr[j]){
                    arr[j+1] = arr[j];//相邻俩个数据交换
                    //arr[j]=tmp; //30行放到36行又可以减少赋值次数
                }else{
                    break;
                }
            }
            arr[j+1]=tmp;//这样写的原因是因为 j-- 当j=0时 j最终变成了-1
        }
    }
}
