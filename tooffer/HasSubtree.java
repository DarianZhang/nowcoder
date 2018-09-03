package com.cn.nowcoder1.tooffer;

import java.util.Arrays;

class TreeNode_h {
	int val = 0;
	TreeNode_h left = null;
	TreeNode_h right = null;
	public TreeNode_h(int val) {
		this.val = val;
	}
}

/**
 * @author 张建伟
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
	public static void main(String[] args) {
		HasSubtree hst = new HasSubtree();
		int[] pre = {8,8,9,2,4,7,7};
		int[] in = {9,8,4,2,7,8,7};
		TreeNode_h pRoot = hst.reConstructBinaryTree(pre, in);
		int[] pre2 = {8,9,2};
		int[] in2 = {9,8,2};
		TreeNode_h pRoot2 = hst.reConstructBinaryTree(pre2, in2);
		
		System.out.println(hst.solution(pRoot, pRoot2));
	}
	public boolean solution (TreeNode_h root1,TreeNode_h root2) {
		if (root2 == null) {
			return false;
		}
		if (root1 == null) {
			return false;
		}
		boolean flag = false;
		if (root1.val == root2.val) {
			flag = isSubtree(root1, root2);
		}
		if (!flag) {
			flag = solution(root1.left, root2);
			if (!flag) {
				flag = solution(root1.right, root2);
			}
		}
		return flag;
	}
	public boolean isSubtree (TreeNode_h root1,TreeNode_h root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val == root2.val) {
			return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);
		}else {
			return false;
		}
	}
	public TreeNode_h reConstructBinaryTree(int [] pre,int [] in) {
        
		if (pre.length == 0) {
			return null;
		}
		TreeNode_h root = make(pre, in);
		return root;
    }
	int mark = 0;
	private TreeNode_h make(int [] pre,int [] in) {
		if (mark >= pre.length || in.length == 0) {
			return null;
		}
		TreeNode_h node = new TreeNode_h(pre[mark]);
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
}
