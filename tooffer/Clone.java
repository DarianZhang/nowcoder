package com.cn.nowcoder1.tooffer;


/**
 * @author 张建伟
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {

	public RandomListNode clone(RandomListNode pHead){
		
		cloneNodes(pHead);
		connectRandomNodes(pHead);
		return reConnectNodes(pHead);
    }
	/*
	 * 第一步：复制原始链表的任意节点N并创建新节点N',再把N'链接到N的后面
	 */
	public void cloneNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pClone = new RandomListNode(pNode.label);
			pClone.label = pNode.label;
			pClone.next = pNode.next;
			pClone.random = null;
			
			pNode.next = pClone;
			pNode = pClone.next;
		}
	}
	/*
	 * 第二步：原始链表上的节点N的random指向S,对应的复制节点N'的random指向S的复制节点S'
	 */
	public void connectRandomNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		while (pNode != null) {
			RandomListNode pClone = pNode.next;
			if (pNode.random != null) {
				pClone.random = pNode.random.next;
			}
			pNode = pClone.next;
		}
	}
	/*
	 * 第三步：把长链表拆成两个链表
	 */
	public RandomListNode reConnectNodes(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		RandomListNode pCloneHead = null;
		RandomListNode pCloneNode = null;
		
		if (pNode!=null) {
			pCloneHead = pCloneNode = pNode.next;
			pNode.next = pCloneNode.next;
			pNode = pNode.next;
		}
		while (pNode!=null) {
			pCloneNode.next = pNode.next;
			pCloneNode = pCloneNode.next;
			pNode = pNode.next = pCloneNode.next;
		}
		return pCloneHead;
	}
}
