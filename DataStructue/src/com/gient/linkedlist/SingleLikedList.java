package com.gient.linkedlist;

/**
 * @author gient
 * @date 2019-07-14
 * @description: ������
 */
public class SingleLikedList{

	// head�̶������������
	private Node head  = new Node();
	
	protected void add(Node node) {
		Node temp = head; 
		while (true) {
			// Ѱ��β�ڵ�
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
	 * ˳�����
	 * @param node
	 */
	public void addByOrder(Node node) {
		Node temp = head;
		while(true) {
			// ֱ����������
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
			System.out.println("����Ϊ�գ�");
			return;
		}
		Node temp = head.next;
		while (true) {
			// ���һ���ڵ㣬��Ȼû�ҵ�
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
			System.out.println("����Ϊ�գ�");
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
			System.out.println("����Ϊ�գ�");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			System.out.println(temp.next);
			temp = temp.next;
		}
	}
	
	/**
	 * ����������Ч���ݵĸ���
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
