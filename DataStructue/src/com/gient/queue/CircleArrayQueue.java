package com.gient.queue;

/**
 * @author gient
 * @date 2019-07-13
 * @description:使用数组实现环形队列
 */
public class CircleArrayQueue {

private static int DEFAULT_MAX_SIZE = 10;
	
	// 用于存放数据
	int[] array;
	
	// 队列的最大容量
	private int maxSize;
	// 队列中数据量大小
	private int size = 0;
	// 队首位置，指向第一个元素
	private int front = 0;
	// 队尾位置，指向最后一个元素
	private int rear = -1;
	
	public CircleArrayQueue() {
		this(DEFAULT_MAX_SIZE);
	}
	
	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	
	public boolean add(int value) {
		if (isFull()) {
			return false;
		}
		rear = (rear + 1) % maxSize;
		array[rear] = value;
		size++;
		
		return true;
	}
	
	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空！");
		}
		int value = array[front];
		front = (front + 1) % maxSize;
		size--;
		return value;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空！");
		}
		return array[front];
	}
	
	/**
	 * 遍历队列
	 * @return
	 */
	public int[] list() {
		int count = 0;
		int[] queue = new int[size];
		for (int i = front; i != rear ; i = (i + 1) % maxSize) {
			queue[count++] = array[i];
		}
		queue[count] = array[rear];
		
		return queue;
	}
	
	/**
	 * 判断队列是否为满队列
	 * @return
	 */
	public boolean isFull() {
		return maxSize == size;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
}
