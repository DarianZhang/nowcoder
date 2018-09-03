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
 * @author �Ž�ΰ
 * ���������Ķ�����������任ΪԴ�������ľ���
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
	ArrayList<ArrayList<Integer>> Print(TreeNode2 pRoot){//��¼������
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
		}
		Queue<TreeNode2> queue = new LinkedList<TreeNode2>();
		queue.add(pRoot);
		
		//��¼ÿһ�е����һ�����
		TreeNode2 lastNodeOfThisLine = pRoot;
		//��ǰ�����Ľڵ�
		TreeNode2 temp = null;
		//��¼���е����һ���ڵ�
		TreeNode2 lastNode = null;
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
	TreeNode2 root;
	String[] partTree;
	public String[] intialInput(String s) {
		String s1=s.substring(1,s.length()-1);
		partTree=s1.split(",");
		return partTree;
	}
	
	public TreeNode2 createNode(TreeNode2 rot,int index) {				//����root��rot������rot��newһ�£��Ӷ�ָ���ĵط���
		if(index>= partTree.length ) {						//�Ӷ�rootʵ��ָ��λ�ò��䣬���Է���ֵ����ΪTreeNode						
			return null;				
		}	
		if(partTree[index].equals("null")  ) {					//equals�жϣ�������==
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
