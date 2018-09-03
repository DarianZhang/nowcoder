package com.cn.nowcoder1.tooffer;

import java.util.Stack;

/**
 * @author 张建伟
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinInStack {
	//声明一个数据栈，一个辅助栈
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
