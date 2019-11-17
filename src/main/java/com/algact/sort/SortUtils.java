package com.algact.sort;

public class SortUtils {
    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i <arr.length-1; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[arr.length-1]+"]");
    }

    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        int[] arr1 = getArr();
        sort.sort(arr1,6);
        print(arr1);
        Sort sort2 = new InsertionSort();
        int[] arr2 = getArr();
        sort2.mySort(arr2,6);
        print(arr2);
        Sort sort3 = new SelectionSort();
        int[] arr3 = getArr();
        sort3.mySort(arr3,6);
        print(arr3);
    }

    static int[] getArr(){
        return new int[]{4,5,6,1,2,3};
    }
}
