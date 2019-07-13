package com.gient.queue;

/**
 * @author gient
 * @date 2019-07-13
 * @description:使用数组实现队列（这种方式，数组不能重复使用）
 */
public class ArrayQueue {

	private static int DEFAULT_MAX_SIZE = 10;
	
	// 用于存放数据
	int[] array;
	
	// 队列的最大容量
	private int maxSize;
	// 队首位置
	private int front = -1;
	// 队尾位置
	private int rear = -1;
	
	public ArrayQueue() {
		this(DEFAULT_MAX_SIZE);
	}
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	
	/**
	 * 向队列中添加数据
	 * @param value
	 * @return
	 */
	public boolean add(int value) {
		boolean flag = false;
		if (isFull()) {
			return flag;
		}
		array[++rear] = value;
		flag = true;
		
		return flag;
	}
	
	/**
	 * 从队列中获取数据
	 * @return
	 */
	public int get() {
		int value;
		if (isEmpty()) {
			throw new RuntimeException("队列为空！");
		}
		
		value = array[++front];
		
		return value;
	}
	
	/**
	 * 判断队列是否满
	 * @return
	 */
	public boolean isFull() {
		
		return rear == maxSize -1;
	}
	
	/**
	 * 判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		
		return front == rear;
	}
}
