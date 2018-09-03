package com.cn.nowcoder1.tooffer;


/**
 * @author �Ž�ΰ
 * ��������ĸ���
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
	 * ��һ��������ԭʼ���������ڵ�N�������½ڵ�N',�ٰ�N'���ӵ�N�ĺ���
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
	 * �ڶ�����ԭʼ�����ϵĽڵ�N��randomָ��S,��Ӧ�ĸ��ƽڵ�N'��randomָ��S�ĸ��ƽڵ�S'
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
	 * ���������ѳ���������������
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
