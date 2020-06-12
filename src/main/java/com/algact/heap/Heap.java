package com.algact.heap;

/**
 * @Description: 堆，完全二叉树
 * @Author: liuc
 * @CreateDate: 2019/11/25 11:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Heap {
    private int[] a;//数组，存储数据，下表从1开始
    private int n;//允许存储的最大数据量
    private int count; //堆中已存储数据

    public Heap(int capacity) {
        this.n = capacity;
        a = new int[capacity + 1];
        count = 0;
    }

    /**
     * 往堆中插入一个数据
     */
    public void insert(int value) {
        if (count >= n) return;
        //每次插入都放在当前数组的最后一个元素
        a[++count] = value;
        //堆化操作 从下往上进行堆化 用子节点和父节点进行比较，如果子节点比父节点大，交换位置
        int i = count;//记录当前子节点所在下标
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
        //print();
    }

    private static void swap(int[] a, int i, int p) {
        int tmp = a[p];
        a[p] = a[i];
        a[i] = tmp;
    }

    /**
     * 删除堆顶元素
     */
    public int delete() {
        if (count == 0) return -1;
        int max = a[1];
        //System.out.println(max);
        //将最后一个元素替换到堆顶，再执行堆化操作，自上而下堆化
        a[1] = a[count--];
        int i = 1;
        while (true) {
            int maxPos = i;
            //如果小于左子节点的值
            if (2 * i <= count && a[i] < a[2 * i]) maxPos = 2 * i;
            //如果左子节点小于右子节点的值
            if (2 * i + 1 <= count && a[maxPos] < a[2 * i + 1]) maxPos = i * 2 + 1;
            //比左右子节点的值都大了，停止
            if (maxPos == i) break;
            //交换当前节点和左右子节点中最大的那个值
            swap(a, i, maxPos);
            i = maxPos;
        }
        return max;
    }

    public void print() {
        System.out.print("[");
        for (int i = 1; i < count; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println(a[count] + "]");
    }

    /**
     * 建堆
     * @param a 数组 a 中的数据从下标 1 到 n 的位置
     * @param n 表示数据的个数
     */
    public static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(20);
        for (int i = 0; i < 20; i++) {
            heap.insert(i + 1);
            //heap.insert((int) (Math.random() * 100));
        }
        heap.print();

        //取出堆顶元素，验证是否正确
        System.out.print("[");
        for (int i = 0; i < 19; i++) {
            System.out.print(heap.delete() + ",");
        }
        System.out.println(heap.delete() + "]");
    }
}
