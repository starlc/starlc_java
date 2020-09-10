package com.algact.sort;

/**
 * @Description: 归并排序
 * @Author: liuc
 * @CreateDate: 2019/11/17 21:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MergingSorting implements Sort {
    @Override
    public void sort(int[] arr, int n) {

    }

    @Override
    public void mySort(int[] a, int n) {
        merge_sort(a, 0, n - 1);
    }

    private void merge_sort(int[] arr, int start, int end) {
        if (start >= end) return ;
        //这个不是真正的中间点吧,只是分成了俩个部分
        int middle = (start+end) / 2;
        merge_sort(arr, start, middle);
        merge_sort(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    /**
     * 合并函数
     * @param arr
     * @param p
     * @param q
     */
    private void merge(int[] arr, int p, int q, int r) {
        int p_start = p,q_start =q+1,index=0;
        int[] temp = new int[r-p+1];
        while (p_start<=q && q_start<= r){
            if (arr[p_start]<=arr[q_start]){
                temp[index++] = arr[p_start++];
            }else {
                temp[index++] = arr[q_start++];
            }
        }

        int start = p_start;
        int end = q;
        if (q_start<=r){ //差一个= 导致出错 当=时表示还有最后一个数据没有复制
            start = q_start;
            end = r;
        }
        //剩余的数据继续复制过来
        while (start <= end) {
            temp[index++] = arr[start++];
        }
        //这个合并没有看懂 看懂了
        for (int i = 0; i <= r-p; i++) {
            arr[p+i] = temp[i];
        }
    }
}
