/**
 * 
 */
package com.starlc.datastructure.btree;

/**
 * 二叉链表的节点
 * @author starlc
 *
 */
public class Node {
	Object value;//值
	Node leftChild;//左孩子
	Node rightChild;//右孩子
	
	public Node(Object value, Node leftChild, Node rightChild) {
		super();
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", leftChild=" + leftChild
				+ ", rightChild=" + rightChild + "]";
	}
}
