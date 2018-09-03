package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 *      和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
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
		int[] left = Arrays.copyOfRange(in, 0, root);//将指定数组的指定范围复制到一个新数组
		int[] right = {};
		if (root+1 < in.length) {
			right = Arrays.copyOfRange(in, root+1, in.length);
		}
		mark++;
		node.left = make(pre, left);
		node.right = make(pre, right);
		return node;
	}
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){//记录二叉树
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(pRoot);
		
		//记录每一行的最后一个结点
		TreeNode lastNodeOfThisLine = pRoot;
		//当前遍历的节点
		TreeNode temp = null;
		//记录队列的最后一个节点
		TreeNode lastNode = null;
		//记录每一行的节点
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
				if (lastNode == lastNodeOfThisLine) {//如果当前行的最后节点为树的最后节点，跳出循环
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
		
		//当前遍历的节点
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
                    queue.offer(temp.left);//向队列中添加一个元素。一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，调用 offer() 方法会返回 false。
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
