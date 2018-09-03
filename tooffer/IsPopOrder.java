package com.cn.nowcoder1.tooffer;

import java.util.Stack;

/**
 * @author 张建伟
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 *    序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *      但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
	/*
	 * 建立一个辅助栈，把压栈序列中的依次压入栈中，期间判断弹出序列的数字是否是栈顶元素。是，就出栈，再判断新的栈顶元素；不是，就进栈。
	 */
	public boolean isPopOrder(int [] pushA,int [] popA) {
	    
		if (pushA==null||popA==null||pushA.length == 0||popA.length==0||pushA.length!=popA.length) {
			return false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int i = 0;
        int j = 0;
        stack.push(pushA[i++]);
        while(j <= popA.length-1){
            while(popA[j] != stack.peek()){
                if(i == pushA.length) return false;
                stack.push(pushA[i++]);
            }
            j++;
            stack.pop();
        }
        return true;
    }
}
