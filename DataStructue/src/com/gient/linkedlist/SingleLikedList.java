package com.gient.linkedlist;

/**
 * @author gient
 * @date 2019-07-14
 * @description: 单链表
 */
public class SingleLikedList{

	// head固定，不存放数据
	private Node head  = new Node();
	
	protected void add(Node node) {
		Node temp = head; 
		while (true) {
			// 寻找尾节点
			if (temp.next == null ) {
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
	}
	
	public void add(int num, String name) {
		Node node = new Node(num, name);
		this.add(node);
	}
	
	/**
	 * 顺序插入
	 * @param node
	 */
	public void addByOrder(Node node) {
		Node temp = head;
		while(true) {
			// 直接在最后添加
			if (temp.next == null) {
				temp.next = node;
				break;
			}
			if (temp.next.num >= node.num) {
				node.next = temp.next;
				temp.next = node;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void addByOrder(int num, String name) {
		Node node = new Node(num, name);
		addByOrder(node);
	}
	
	public void update(Node node) {
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		Node temp = head.next;
		while (true) {
			// 最后一个节点，依然没找到
			if (temp == null) {
				break;
			}
			if(node.num == temp.num) {
				temp.name = node.name;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void update(int num, String name) {
		Node node = new Node(num, name);
		update(node);
	}
	
	public void delete(Node node) {
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		
		Node temp = head;
		
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.num == node.num) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void delete(int num) {
		Node node = new Node(num, "");
		delete(node);
	}
	
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空！");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			System.out.println(temp.next);
			temp = temp.next;
		}
	}
	
	/**
	 * 计算链表有效数据的个数
	 * @return
	 */
	public int length() {
		
		int len = 0;
		
		if (head.next == null) {
			return len;
		}
		
		Node current = head;
		
		while(true) {
			if (current.next != null) {
				len++;
				current = current.next;
			} else {
				break;
			}
		}
		
		return len;
	}
	

	class Node {
		private int num;
		private String name;
		public Node next;
		
		public Node() {};
		
		public Node(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", name=" + name + "]";
		}

	}

	public Node getHead() {
		return head;
	}
	
}
