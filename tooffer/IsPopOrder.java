package com.cn.nowcoder1.tooffer;

import java.util.Stack;

/**
 * @author �Ž�ΰ
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ�
 * ��������1,2,3,4,5��ĳջ��ѹ��˳��
 *    ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 *      ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 */
public class IsPopOrder {
	/*
	 * ����һ������ջ����ѹջ�����е�����ѹ��ջ�У��ڼ��жϵ������е������Ƿ���ջ��Ԫ�ء��ǣ��ͳ�ջ�����ж��µ�ջ��Ԫ�أ����ǣ��ͽ�ջ��
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
