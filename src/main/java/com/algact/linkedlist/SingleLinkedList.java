package com.algact.linkedlist;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.sound.midi.Soundbank;

/**
* @Description:    单链表反转
* @Author:         liuc
* @CreateDate:     2019/11/15 22:02
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SingleLinkedList {

    public static class Node<T>{
        Node next;
        T  value;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        printNode(getNodeList());
        printNode(reversalNodeList());
        printNode(inverseLinkList(getNodeList()));
    }

    /**
     * 反转单向链表 遍历了3次
     */
    public static Node reversalNodeList(){
        Node node = getNodeList();
        int size = 0;
        Node temp = node;
        while (temp!=null){
            size++;
            temp = temp.next;
        }
        Node[] arr = new Node[size];
        int count = 0;
        while (node!=null){
            arr[count++]=node;
            node = node.next;
        }
        Node reversalNode = arr[count-1];
        //a5->a4->a3...->a0->null
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {//处理头结点
                reversalNode.next = arr[i - 1];
            }else if (i == 0) {//处理尾节点
                arr[i].next = null;
            }else {
                arr[i].next = arr[i - 1];
            }
        }
        return reversalNode;
    }

    //无头结点的链表翻转
    public static Node inverseLinkList(Node p){

        //　Head　为新建的一个头结点
        Node Head = new Node(9999);
        // p　为原来整个链表的头结点,现在Head指向　整个链表
        Head.next = p;
        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while(Cur != null){
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.value);
            Cur = next;
        }

        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return Head;

    }

    public static void printNode(Node node) {
        do {
            System.out.print(node.value);
            node = node.next;
        } while (node != null);
        System.out.println();
    }
    /**
     * 获取一个链表
     * @return
     */
    public static Node getNodeList(){
        Node n1 = new Node("a");
        Node n2 = new Node("b");
        Node n3 = new Node("c");
        Node n4 = new Node("d");
        Node n5 = new Node("e");
        Node n6 = new Node("f");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        return n1;
    }
}
