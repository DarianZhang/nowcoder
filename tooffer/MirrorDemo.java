package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode2 {
	int val = 0;
	TreeNode2 left = null;
	TreeNode2 right = null;
	public TreeNode2 (int val) {
        this.val = val;
    }
}

/**
 * @author 张建伟
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorDemo {
	
	public void Mirror(TreeNode2 root) {
		if(root==null) return;
        TreeNode2 temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }
	public static void main(String[] args) {
		MirrorDemo mirrorDemo = new MirrorDemo();
		String treeExp="[8,6,10,5,7,9,11]";
		TreeNode2 root2 = mirrorDemo.createTree(treeExp);
		mirrorDemo.Mirror(root2);
		System.out.println(mirrorDemo.Print(root2));
	}
	ArrayList<ArrayList<Integer>> Print(TreeNode2 pRoot){//记录二叉树
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Queue<TreeNode2> queue = new LinkedList<TreeNode2>();
		queue.add(pRoot);
		
		//记录每一行的最后一个结点
		TreeNode2 lastNodeOfThisLine = pRoot;
		//当前遍历的节点
		TreeNode2 temp = null;
		//记录队列的最后一个节点
		TreeNode2 lastNode = null;
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
	TreeNode2 root;
	String[] partTree;
	public String[] intialInput(String s) {
		String s1=s.substring(1,s.length()-1);
		partTree=s1.split(",");
		return partTree;
	}
	
	public TreeNode2 createNode(TreeNode2 rot,int index) {				//传入root给rot后，由于rot会new一下，从而指向别的地方，
		if(index>= partTree.length ) {						//从而root实际指向位置不变，所以返回值类型为TreeNode						
			return null;				
		}	
		if(partTree[index].equals("null")  ) {					//equals判断，而不是==
			return null;
		}
		rot=new TreeNode2(Integer.parseInt(partTree[index]));
		rot.left=createNode(rot.left,2*index+1);
		rot.right=createNode(rot.right,2*index+2);		
		return rot;
	}
	
	public TreeNode2 createTree(String s) {
		partTree=intialInput(s);
		root=createNode(root,0);
		return root;
	}

}
