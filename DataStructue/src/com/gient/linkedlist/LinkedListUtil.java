package com.gient.linkedlist;

import java.util.Iterator;
import java.util.Stack;

import com.gient.linkedlist.SingleLikedList.Node;

/**
 * @author gient
 * @date 2019-07-14
 * @description:单链表的相关练习题
 */
public class LinkedListUtil {

	/**
	 * 查找单链表倒数第index个节点
	 * @param index
	 * @return
	 */
	public static Node findNodeFromEnd(SingleLikedList list, int index) {
		
		if (list == null) {
			return null;
		}
		
		// 获取链表长度length
		int len = list.length();
		if (index < 0 || (len - index) < 0) {
			return null;
		}
		
		Node temp = list.getHead();
		
		// 遍历至length-size处，即待查找节点的前一个节点
		for (int i = 0; i < len - index; i++) {
			temp = temp.next;
		}
		return temp.next;
	}
	
	/**
	 * 将单链表进行反转
	 * @param list
	 * @return
	 */
	public static SingleLikedList reverse(SingleLikedList list) {
		if (list == null) {
			return null;
		}
		SingleLikedList reverseList = new SingleLikedList();
		Node reverseHead = reverseList.getHead();
		
		Node head = list.getHead();
		Node current = head.next;
		Node next = null;
		// 遍历list
		while(true) {
			if (current == null) {
				break;
			}
			// 保存当前节点下一个节点
			next = current.next;
			// 插入到反转链表中
			current.next = reverseHead.next;
			reverseHead.next = current;
			current = next;
		}
		return reverseList;
	}
	
	/**
	 * 从尾到头打印单链表，利用栈实现
	 * @param list
	 */
	public static void printFromEnd(SingleLikedList list) {
		if(list == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		
		Node current = list.getHead();
		
		while (current.next != null) {
			stack.push(current.next);
			current = current.next;
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	/**
	 * 将两个有序链表合并成一个有序链表
	 * 将fromList合并到toList
	 * @param fromList
	 * @param toList
	 * @return
	 */
	public static SingleLikedList mergeByOrder(SingleLikedList fromList, SingleLikedList toList) {
		if (fromList == null) {
			return toList;
		}
		if (toList == null) {
			return fromList;
		}
		
		// 直接取待插入的节点
		Node fCurrent = fromList.getHead().next;
		// 取头节点，单链表操作要获取操作位置的前一个节点
		Node tCurrent = toList.getHead();
		
		Node fNext = null;
		
		while(fCurrent != null) {
			// 按顺序插入到toList中
			while (true) {
				// 合并
				if (tCurrent.next.getNum() >= fCurrent.getNum()) {
					fNext = fCurrent.next;
					fCurrent.next = tCurrent.next;
					tCurrent.next = fCurrent;
					
					tCurrent = fCurrent;
					fCurrent = fNext;
					break;
				}
				// fromList后移
				tCurrent = tCurrent.next;
			}
		}
		return toList;
	}
}
