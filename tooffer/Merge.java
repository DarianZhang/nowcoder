package com.cn.nowcoder1.tooffer;

import java.util.Iterator;

class ListNode_m{
	int val; 
	ListNode_m next = null;
	public ListNode_m(int val) {
		this.val = val;
	}
}

/**
 * @author 张建伟
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
	/*
	 * 递归
	 */
	public static ListNode_m solution(ListNode_m list1,ListNode_m list2) {
		if (list1 == null) {
			return list2;
		}else if (list2 == null) {
			return list1;
		}
		ListNode_m listnode = null;
		if (list1.val > list2.val ) {
			listnode = list2;
			listnode.next = solution(list1, list2.next);
		}else {
			listnode = list1;
			listnode.next = solution(list1.next, list2);
		}
		return listnode;
	}

	public static ListNode_m solution2(ListNode_m list1,ListNode_m list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode_m mergeHead = null;
		ListNode_m current = null;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				if (mergeHead == null) {
					mergeHead = current = list1;
				} else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			} else {
				if (mergeHead == null) {
					mergeHead = current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			current.next = list2;
		} else {
			current.next = list1;
		}
		return mergeHead;
	}
	
	static ListNode_m createLinkedList(int arr[], int n){
		if( n == 0 ) 
			return null;
		ListNode_m head = new ListNode_m(arr[0]);
		ListNode_m curNode = head;
		for(int i = 1; i < n; i++){
			curNode.next = new ListNode_m(arr[i]);
			curNode = curNode.next;
		}
		return head;
	}
	static void printLinkedList(ListNode_m head){
		ListNode_m curNode = head;
		while( curNode != null){
			System.out.print(curNode.val+" -> ");
			curNode = curNode.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,20};
		int n = arr.length;
		int arr2[] = {1,3,4,9,10};
		int n2 = arr2.length;
		
		ListNode_m head = createLinkedList (arr, n);
		ListNode_m head2 = createLinkedList (arr2, n2);
		
		ListNode_m node = solution(head, head2);
		printLinkedList(node);
		
		ListNode_m node2 = solution2(head, head2);
		printLinkedList(node2);
	}
}
