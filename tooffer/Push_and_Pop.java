package com.cn.nowcoder1.tooffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author �Ž�ΰ
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class Push_and_Pop {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	/*public void push(int node) {//���
        stack1.push(node);
    }
    
    public int pop() {			//����
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
