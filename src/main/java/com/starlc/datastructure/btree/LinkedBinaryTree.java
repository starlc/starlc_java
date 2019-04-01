/**
 * 
 */
package com.starlc.datastructure.btree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import sun.org.mozilla.javascript.internal.ObjArray;

/**
 * @author starlc
 *
 */
public class LinkedBinaryTree implements BinaryTree {

	private Node root;// 根节点

	public LinkedBinaryTree() {
	}

	public LinkedBinaryTree(Node root) {
		this.root = root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#size()
	 */
	@Override
	public int size() {
		System.out.print("树的size：");
		return this.size(root);
	}

	private int size(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftSize = this.size(root.leftChild);
			int rightSize = this.size(root.rightChild);
			// 返回左子树 右子树之和 +1
			return leftSize + rightSize + 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#getHeight()
	 */
	@Override
	public int getHeight() {
		System.out.print("树的高度:");
		return getHeight(root);
	}

	private int getHeight(Node root) {
		if (root == null) {
			return 0;
		} else {
			// 获取左子树的高度
			int nl = this.getHeight(root.leftChild);

			// 获取右子树的高度
			int nr = this.getHeight(root.rightChild);

			// 找到俩者中间较大的 并+1
			return nl > nr ? nl + 1 : nr + 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#findKey(int)
	 */
	@Override
	public Node findKey(int value) {
		return this.findKey(value, root);
	}

	public Node findKey(Object value, Node root) {

		if (root == null) {// 递归结束条件1：结点为空，可能是整个树的根节点，也可能是递归调用中叶子节点中左孩子和右孩子
			return null;
		} else if (root != null && root.value == value) {// 递归的结束条件2：找到了
			return root;
		} else {// 递归体
			Node node1 = this.findKey(value, root.leftChild);
			Node node2 = this.findKey(value, root.rightChild);
			if (node1 != null && node1.value == value) {
				return node1;
			} else if (node2 != null && node2.value == value) {
				return node2;
			} else {
				return null;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#preOrderTraverse()
	 */
	@Override
	public void preOrderTraverse() {
		// 输出当前根节点的值
		if (root != null) {
			System.out.print(root.value + " ");

			// 对左子树进行先序遍历
			BinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();

			// 对右子树进行先序遍历
			BinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#inOrderTraverse()
	 */
	@Override
	public void inOrderTraverse() {
		System.out.print("中序遍历：");
		inOrderTraverse(root);
		System.out.println();
	}

	private void inOrderTraverse(Node root) {
		// 输出当前根节点的值
		if (root != null) {
			// 对左子树进行先序遍历
			this.inOrderTraverse(root.leftChild);

			System.out.print(root.value + " ");

			// 对右子树进行先序遍历
			this.inOrderTraverse(root.rightChild);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#postOrderTraverse()
	 */
	@Override
	public void postOrderTraverse() {
		System.out.print("后序遍历：");
		postOrderTraverse(root);
		System.out.println();
	}

	@Override
	public void postOrderTraverse(Node root) {
		// 输出当前根节点的值
		if (root != null) {
			// 对左子树进行先序遍历
			this.postOrderTraverse(root.leftChild);

			// 对右子树进行先序遍历
			this.postOrderTraverse(root.rightChild);

			System.out.print(root.value + " ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#inOrderByStack()
	 */
	@Override
	public void inOrderByStack() {
		System.out.println("中序非递归遍历:");
		// 创建栈   后进先出
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.rightChild;
			}
		}
		System.out.println();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#preOrderByStack()
	 */
	@Override
	public void preOrderByStack() {
		System.out.println("前序非递归遍历:");
		// 创建栈   后进先出
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				System.out.print(current.value + " ");//先处理当前的、再处理左边、再处理右边
				stack.push(current.rightChild);
				current = current.leftChild;
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
			}
		}
		System.out.println();
	}

	/*
	 * (non-Javadoc)
	 * 对于每个节点，都压入两遍，在循环体中，每次弹出一个节点赋给p，
	 * 如果p仍然等于栈的头结点，说明p的孩子们还没有被操作过，应该把
	 * 它的孩子们加入栈中，否则，访问p。也就是说，第一次弹出，将p的
	 * 孩子压入栈中，第二次弹出，访问p。
	 * @see com.starlc.datastructure.btree.BinaryTree#postOrderByStack()
	 */
	@Override
	public void postOrderByStack() {
		System.out.println("后序非递归遍历:");
		// 创建栈   后进先出
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		stack.push(current);
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.getFirst();stack.pop();
			if (!stack.isEmpty()&& current ==stack.getFirst()) {
				if (current.rightChild != null) {
					stack.push(current.rightChild);
					stack.push(current.rightChild);
				}
				if (current.leftChild != null) {
					stack.push(current.leftChild);
					stack.push(current.leftChild);
				}
			}else {
				System.out.print(current.value+" ");
			}
		}
		System.out.println();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.starlc.datastructure.btree.BinaryTree#levelOrderByStack()
	 */
	@Override
	public void levelOrderByStack() {
		System.out.println("按照层次遍历二叉树");
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();//先进先出队列
		queue.add(root);
		while (queue.size() != 0) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Node temp = queue.poll();
				System.out.print(temp.value + " ");
				if (temp.leftChild != null)
					queue.add(temp.leftChild);
				if (temp.rightChild != null)
					queue.add(temp.rightChild);
			}
		}

		System.out.println();
	}

}
