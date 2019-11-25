package com.starlc.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 单链表环
 * @Author: liuc
 * @CreateDate: 2019/11/8 10:27
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SinglyList {

    /**
     * 单向链表内部节点
     */
    private static class Node<E> {
        E item;
        Node next;

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item) {
            this.item = item;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node<?> node = (Node<?>) o;

            if (item != null ? !item.equals(node.item) : node.item != null) return false;
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override
        public int hashCode() {
            int result = item != null ? item.hashCode() : 0;
            //result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

    /**
     * 检测链表是否有环
     * 解决思路1：(使用快慢指针，慢指针每次走一步，快指针每次走俩步,如果链表中没有环，
     * 则快慢指针会依次遍历完整个链表，如果有环，则快慢指针会在环中某个点相遇)
     */
    public static boolean hasLoop(Node headNode) {
        if (headNode == null) {
            return false;
        }
        Node slow = headNode;
        Node quick = headNode;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            //不存在环时，快指针先走完，如果快指针走完了，同样也说明没有环
            if (quick == null ) {
                return false;
            }
            quick = quick.next.next;

            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    private static Map<Node,Integer> map = new HashMap<>();
    /**
     * 足迹法
     * 这种确实是可以的，开始我存在一个误区，认为Node重写了hashCode方法，所以当存在相同值，并且指向节点的值也相同时，这俩个对象的hashcode 取值会相同
     * 实际情况是，Object默认的hashcode方法返回值和内存地址有关。
     * @param headNode
     * @param index
     * @return
     */
    public static boolean hasLoop2(Node headNode,int index){
        if (headNode==null || headNode.next==null){
            return false;
        }
        if (map.containsKey(headNode)){
            return true;
        }else {
            map.put(headNode,index);
            return hasLoop2(headNode.next,++index);
        }
    }

    public static void main(String[] args) {
        Node<String> n1 = new Node<>("a");
        Node<String> n2 = new Node<>("a");
        Node<String> n3 = new Node<>("a");
        Node<String> n4 = new Node<>("b");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = n2;
        System.out.println(hasLoop2(n1,0));
    }
}
