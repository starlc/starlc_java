package com.algact.sort;
/**
* @Description:    快速排序
* @Author:         liuc
* @CreateDate:     2019/11/17 21:59
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class QuickSort implements Sort{
    @Override
    public void sort(int[] arr, int n) {

    }

    @Override
    public void mySort(int[] arr, int n) {
        //先设置分区点，
        //将小于该点的数据放在数组左边，大于的放在右边
        //递归解决左边的，和 右边的
        //p q r

        quicksort(arr, 0, n-1);
    }
    private void quicksort(int[] arr,int p,int r) {
        //先设置分区点，
        //将小于该点的数据放在数组左边，大于的放在右边
        //递归解决左边的，和 右边的
        //p q r
        //1分区点，2排序
        if (p>=r)return; //<=
        int q = partionArr(arr,p,r);
        quicksort(arr,p,q-1);
        quicksort(arr,q+1,r);
    }

    private int partionArr(int[] arr, int p, int r) {
        int q = arr[r];
        int i=p;
        for (int j = p; j < r; j++) {
            if (arr[j]<q){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }
}
