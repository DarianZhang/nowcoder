package com.cn.nowcoder1.tooffer;

import java.util.Stack;

/**
 * @author �Ž�ΰ
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 */
public class MinInStack {
	//����һ������ջ��һ������ջ
	static Stack<Integer> datastack = new Stack<Integer>();
	static Stack<Integer> minstack = new Stack<Integer>();
	public void push(int node) {
		datastack.push(node);
        if (minstack.isEmpty()||node <= minstack.peek()) {
			minstack.add(node);
		}else {
			minstack.add(minstack.peek());
		}
    }
    
    public void pop() {
       
		datastack.pop();
		minstack.pop();
    }
    
    public int top() {
		
    	return datastack.peek();
    }
    
    public int min() {
    	
    	return minstack.peek();
    }
}
