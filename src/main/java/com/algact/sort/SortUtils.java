package com.algact.sort;

import com.starlc.common.JDKDynamicProxy;
import com.starlc.common.Watcher;

import java.lang.reflect.Proxy;
import java.util.List;

public class SortUtils {
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static void main(String[] args) {
        Sort proxyInstance = new ProxySort(new BubbleSort()).getProxy();
        proxyInstance.mySort(getArr(),6);
        Sort proxyInstance2 = new ProxySort(new InsertionSort()).getProxy();
        proxyInstance2.mySort(getArr(),6);
        Sort proxyInstance3 = new ProxySort(new SelectionSort()).getProxy();
        proxyInstance3.mySort(getArr(),6);
        Sort proxy4 = new ProxySort(new MergingSorting()).getProxy();
        proxy4.mySort(getArr(),6);
        Sort proxy5 = new ProxySort(new QuickSort()).getProxy();
        proxy5.mySort(getArr(),6);
    }

    static int[] getArr() {
        return new int[]{4, 5, 6, 1, 2, 3};
    }

    /**
     * 生成长度为n的数组
     */
    static int[] getArr(int n) {
        int[] re = new int[n];
        for (int i = 0; i < n; i++) {
            re[i] = (int) (Math.random() * 100*n);
        }
        return re;
    }
}
