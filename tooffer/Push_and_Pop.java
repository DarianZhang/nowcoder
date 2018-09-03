package com.cn.nowcoder1.tooffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 张建伟
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Push_and_Pop {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	/*public void push(int node) {//入队
        stack1.push(node);
    }
    
    public int pop() {			//出队
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
    	return stack2.pop();
    }*/
    
	public void push(int node) {
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(node);
	}
	public int pop() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
    public static void main(String[] args) {
    	
    	Push_and_Pop pap = new Push_and_Pop();
    	
		int[] a = {3,56,74,4,21,15,36,45};
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			pap.push(a[i]);
			queue.add(pap.pop());
		}
		
		
		for (Integer integer : queue) {
			System.out.print(integer+" ");
		}
	}
}
