package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}
 *      �������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */

//Definition for binary tree

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
public class ReConstructBinaryTree {

	TreeNode treeNode = null;
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        
		if (pre.length == 0) {
			return null;
		}
		TreeNode root = make(pre, in);
		return root;
    }
	int mark = 0;
	private TreeNode make(int [] pre,int [] in) {
		if (mark >= pre.length || in.length == 0) {
			return null;
		}
		
		TreeNode node = new TreeNode(pre[mark]);
		int root = in.length;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[mark]) {
				root = i;
				break;
			}
		}
		int[] left = Arrays.copyOfRange(in, 0, root);//��ָ�������ָ����Χ���Ƶ�һ��������
		int[] right = {};
		if (root+1 < in.length) {
			right = Arrays.copyOfRange(in, root+1, in.length);
		}
		mark++;
		node.left = make(pre, left);
		node.right = make(pre, right);
		return node;
	}
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){//��¼������
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);
		
		//��¼ÿһ�е����һ�����
		TreeNode lastNodeOfThisLine = pRoot;
		//��ǰ�����Ľڵ�
		TreeNode temp = null;
		//��¼���е����һ���ڵ�
		TreeNode lastNode = null;
		//��¼ÿһ�еĽڵ�
		ArrayList<Integer> line = new ArrayList<Integer>();
		
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (temp.left != null) {
				queue.add(temp.left);
				lastNode = temp.left;
			}
			if (temp.right != null) {
				queue.add(temp.right);
				lastNode = temp.right;
			}
			line.add(temp.val);
			if (temp == lastNodeOfThisLine) {
				result.add(line);
				if (lastNode == lastNodeOfThisLine) {//�����ǰ�е����ڵ�Ϊ�������ڵ㣬����ѭ��
					break;
				}
				lastNodeOfThisLine = lastNode;
				line = new ArrayList<Integer>();
			}
		}
		return result;
	}
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> line = new ArrayList<Integer>();
		if (root == null) {
			return line;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		//��ǰ�����Ľڵ�
		TreeNode temp = null;
        
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			line.add(temp.val);
		}
		return line;
    }
	public void PrintFromTopToBottom2(TreeNode root) {
		if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()){
            for(int size=queue.size();size>0;size--){
                temp = queue.poll();
                System.out.print(temp.val);
                System.out.print("\t");
                if(temp.left!=null)
                    queue.offer(temp.left);//����������һ��Ԫ�ء�һЩ�����д�С���ƣ�����������һ�����Ķ����м���һ��������� offer() �����᷵�� false��
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
		ReConstructBinaryTree rcbt = new ReConstructBinaryTree();
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		TreeNode pRoot = rcbt.reConstructBinaryTree(pre, in);
		System.out.println(rcbt.Print(pRoot));
		System.out.println();
		System.out.println(rcbt.PrintFromTopToBottom(pRoot));
		System.out.println();
		rcbt.PrintFromTopToBottom2(pRoot);
	}
}
