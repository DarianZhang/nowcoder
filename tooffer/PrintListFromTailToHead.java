package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
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
            stack.push(listNode.val);//把项压入堆栈顶部
            listNode = listNode.nextListNode;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());//移除堆栈顶部的对象，并作为此函数的值返回该对象
        }
        return list; 
	}
	
	ArrayList<Integer> alist = new ArrayList<Integer>();
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {//递归
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
