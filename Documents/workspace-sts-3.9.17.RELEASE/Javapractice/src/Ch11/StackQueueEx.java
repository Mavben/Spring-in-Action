package Ch11;

import java.util.*;

public class StackQueueEx {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		
		st.push("0");
		st.push("1");
		st.push("2");
		st.push("3");

		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		// =스택= 출력하기
		System.out.println("= Stack =");
		// 스택이 비어있지 않으면
		while(!st.empty()) {
			// 꺼내기
			System.out.println(st.pop());
		}
		
		// =큐= 출력하기
		System.out.println("= Queue =");
		// 큐가 비어있지 않으면
		while(!q.isEmpty()) {
			// 꺼내기
			System.out.println(q.poll());
		}
	}
}
