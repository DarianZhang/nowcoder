package com.cn.nowcoder1.tooffer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class ListNode_f {
	int val;
	ListNode_f next = null;
	ListNode_f(int val) {
        this.val = val;
    }
}
/**
 * @author 张建伟
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
	public ListNode_f solution(ListNode_f head, int key){
		if (head == null||key <= 0) {
			return null;
		}
		ListNode_f start = head;
		ListNode_f end = head;
		for (int i = 0; i < key-1; i++) {
			if (end.next!=null) {
				end = end.next;
			}
		}
		if (end == null) {
			return null;
		}
		while (end.next!=null) {
			start = start.next;
			end = end.next;
		}
		return start;
 	}
	static ListNode_f createLinkedList(int arr[], int n){
		if( n == 0 ) 
			return null;
		ListNode_f head = new ListNode_f(arr[0]);
		ListNode_f curNode = head;
		for(int i = 1; i < n; i++){
			curNode.next = new ListNode_f(arr[i]);
			curNode = curNode.next;
		}
		return head;
	}
	static void printLinkedList(ListNode_f head){
		ListNode_f curNode = head;
		while( curNode != null){
			System.out.print(curNode.val+"     ");
			curNode = curNode.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		FindKthToTail fktt = new FindKthToTail();
		int arr[] = {1,2,3,4,20};
		int n = arr.length;
		ListNode_f head = createLinkedList (arr, n);
		ListNode_f key = fktt.solution(head, 3);
		printLinkedList(key);
	}
}
