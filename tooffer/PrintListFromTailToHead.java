package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��
 */
class ListNode {
	int val;
	ListNode nextListNode = null;
	
	public ListNode(int val) {
		this.val = val;
	}
	
}
public class PrintListFromTailToHead {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);//����ѹ���ջ����
            listNode = listNode.nextListNode;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());//�Ƴ���ջ�����Ķ��󣬲���Ϊ�˺�����ֵ���ظö���
        }
        return list; 
	}
	
	ArrayList<Integer> alist = new ArrayList<Integer>();
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {//�ݹ�
		if (listNode == null) {
			return alist;
		}
		printListFromTailToHead2(listNode.nextListNode);
		alist.add(listNode.val);
		return alist;
    }
	
	
	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.nextListNode = new ListNode(2);
		ln.nextListNode.nextListNode = new ListNode(3);
		ln.nextListNode.nextListNode.nextListNode = new ListNode(4);
		
		PrintListFromTailToHead p = new PrintListFromTailToHead();
		System.out.println(p.printListFromTailToHead(ln));
		System.out.println();
		System.out.println(p.printListFromTailToHead2(ln));
	}
}
