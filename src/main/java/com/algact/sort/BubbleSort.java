package com.algact.sort;

/**
* @Description:    冒泡排序
* @Author:         liuc
* @CreateDate:     2019/11/17 16:47
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BubbleSort implements Sort{

    /**
     * 冒牌排序每次比较相邻俩个数据的大小，如果前者比后者大则交换顺序
     * 时间复杂度为O(n^2) 空间复杂度为O(1)
     * 原地排序算法 和 稳定排序算法
     * 复杂度分析：对于n个数一共有n！种排序方式,我们将其中任意俩个数据的有序 称为有序度
     * 那么最好情况下，所有数据都是有序的，则有序度 为Cn2 n(n-1)/2 最坏情况下 是逆序的 有序度为0
     * 取平均情况 n(n-1)/4 由于每一次比较都是相邻俩个数据的交换 所以平均时间复杂度 为O(n^2)
     * 空间复杂度 由于我们只借助了常数级别的空间来辅助 所以为O（1）
     * @param a 要排序的数组
     * @param n 数字的大小
     * @return
     */
    @Override
    public void sort(int[] a,int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    @Override
    public void mySort(int[] arr, int n) {
        if (n<=1)return;
        for (int i = 0; i < n; i++) {
            boolean flag = false;//如果某次冒泡过程中都没有发生数据交换，则说明所有数据已经有序了
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag)break;
        }
    }
}
