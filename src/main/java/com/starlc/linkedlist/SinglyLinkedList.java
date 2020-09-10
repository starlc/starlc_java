package com.starlc.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 单向链表
 *
 * 单链表反转（借助栈来实现，遍历链表时，每走一步将该数据进行压栈，遍历完成后将栈数据依次出栈组成新的链表 时间复杂度为O(n)，空间复杂度也是O(n)）
 *
 * 链表中环的检测
 *  解决思路1：(使用快慢指针，慢指针每次走一步，快指针每次走俩步,如果链表中没有环，则快慢指针会依次遍历完整个链表，如果有环，则快慢指针会在环中某个点相遇)
 *
 * 两个有序的链表合并
 *
 * 删除链表倒数第 n 个结点
 *
 * 求链表的中间结点
 */
public class SinglyLinkedList<E> implements List<E> {
    /**
     * 链表头
     */
    transient Node<E> head;
    /**
     * 链表尾节点
     */
    transient Node<E> tail;

    private int size;

    public SinglyLinkedList() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * 时间复杂度为O(n)
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> e = head; e != null; e = e.next) {
                if (e.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> e = head; e != null; e = e.next) {
                if (e.item.equals(o)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * 单向链表内部节点
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node next;

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public List<E> reverse(List<E> list){
        return new SinglyLinkedList<E>();
    }

}
