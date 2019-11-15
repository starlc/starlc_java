package com.algact.linkedlist;

import sun.awt.SunHints;

/**
* @Description:    单向链表
 *  1）单链表的插入、删除、查找操作；
 *  2）单链表反转
 *  3）删除链表倒数第 n 个结点
 *  4）求链表的中间结点
* @Author:         liuc
* @CreateDate:     2019/11/15 22:58
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SinglyLinkedList<T> {
    private Node head = null;

    private Node createNode(T value){
        return new Node(null,value);
    }
    /**
     * 插入值到头部
     * @param value
     */
    public void insertToHead(T value){
        if (head==null){
            head = createNode(value);
        }else {
            Node newNode = createNode(value);
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 插入到尾部
     * @param value
     */
    public void insertToTail(T value){
        if(head==null){
            head = createNode(value);
        }else {
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = createNode(value);
        }
    }

    /**
     * 插入到某个节点之前
     * @param p
     * @param value
     */
    public void insertBeforeNode(Node p,T value){
        if (p==null)return;
        Node newNode = createNode(value);
        if (p==head){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node q = head;
        while (q.next!=null && !q.next.equals(p)){
            q = q.next;
        }
        q.next = newNode;
        newNode.next = p;
    }

    public void insertAfterNode(Node p,T value){
        Node q = p.next;
        Node newNode = createNode(value);
        p.next = newNode;
        newNode.next = q;
    }
    public Node findByIndex(int index){
        int count = 0;
        Node p = head;
        while (count!=index && p!=null){
            p = p.next;
            ++count;
        }
        return p;
    }

    public Node findByValue(T value){
        Node p = head;
        while ( p!=null && !p.value.equals(value)){
            p = p.next;
        }
        return p;
    }

    public void deleteByNode(Node p) {
        if (p==null || head==null)return;
        Node q = head;
        while (q != null && q.next!=p){
            q = q.next;
        }
        if (q==null){
            return;
        }
        q.next = p.next;
    }

    public void deleteByValue(T value) {
        if (head == null || value==null )return;
        Node q = head;
        while (q.next!=null && !q.next.value.equals(value)){
            q = q.next;
        }
        if (q==null ){return;}
        if (q.next!=null){
            Node n = q.next.next;
            q.next = n;
        }
    }

    //　判断是否为回文

    public boolean palindrome(){
        return false;
    }

    //带结点的链表翻转
    public Node inverseLinkList_head(Node p){
        return null;
    }

    public  void printAll(){
        Node q = head;
        do {
            System.out.print(q.value);
            q = q.next;
        } while (q != null);
        System.out.println();
    }
    //单向链表的尾节点有意义吗？
    private Node tail;
    public static class Node<T>{
        private Node next;
        private T value;

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public static void main(String[]args){

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        // int data[] = {1,2,5,2,1};
        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertToTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        link.insertToHead(6);
        link.printAll();
        Node p = link.findByValue(6);
        link.insertBeforeNode(p,7);
        link.printAll();
        link.insertAfterNode(p,"8");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }
}
