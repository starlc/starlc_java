package com.starlc.datastructure.btree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		//创建一个二叉树  
		/*
		 *   1
		 * 4	2
		 *  5  3 6
		 *  	  7
		 */
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, node5);
		
		
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, node7);
		
		Node node3 = new Node(3, null, null);
		
		Node node2 = new Node(2, node3, node6);
		
		Node node1 = new Node(1, node4, node2);
		BinaryTree bTree = new LinkedBinaryTree(node1);
		//BinaryTree bTree = new LinkedBinaryTree(node);
		//判断二叉树是否为空
		System.out.println(bTree.isEmpty());
		
		//先序遍历递归 1452367
		System.out.println("先序遍历:");
		bTree.preOrderTraverse();
		System.out.println();
		
		//中序遍历递归 4513267
		bTree.inOrderTraverse();
		
		//后序遍历递归 5437621
		bTree.postOrderTraverse();
		
		//前序遍历非递归
		bTree.preOrderByStack();
		//中序遍历非递归（借助栈）
		bTree.inOrderByStack();
		//hou序遍历非递归（借助栈）
		bTree.postOrderByStack();
		
		//按照层次遍历（借助队列）
		bTree.levelOrderByStack();
		
		//在二叉树中查找某个值
		System.out.println(bTree.findKey(1));
		System.out.println(bTree.findKey(7));
		System.out.println(bTree.findKey(8));
		
		//二叉树的高度
		System.out.println(bTree.getHeight());
		
		//二叉树的节点数量
		System.out.println(bTree.size());
		
	}
}
