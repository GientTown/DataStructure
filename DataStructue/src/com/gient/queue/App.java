package com.gient.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gient
 * @date 2019-07-13
 * @description:≤‚ ‘
 */
public class App {

	public static void main(String[] args) {
		CircleArrayQueue queue = new CircleArrayQueue();
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		char key = ' ';
		
		while (loop) {
			System.out.println("add");
			System.out.println("get");
			System.out.println("peek");
			System.out.println("list");
			System.out.println("quit");
			
			key = scanner.next().charAt(0);
			
			switch (key) {
			case 'a':
				System.out.println("«Î ‰»Î ˝æ›£∫");
				int value = scanner.nextInt();
				queue.add(value);
				break;
				
			case 'g':
				System.out.println(queue.get());
				break;
				
			case 'p':
				System.out.println(queue.peek());
				break;
				
			case 'l':
				System.out.println(Arrays.toString(queue.list()));
				break;
				
			case 'q':
				scanner.close();
				loop = true;
				break;
				
			default:
				break;
			}
			
		}
	}
	
}
