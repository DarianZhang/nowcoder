package com.cn.nowcoder1.tooffer;

/**
 * @author �Ž�ΰ
 * ������������˫������
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class Convert {

	public TreeNode_Convert convert(TreeNode_Convert pRootOfTree) {
        
		if (pRootOfTree == null) {
			return null;
		}
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
		TreeNode_Convert left = convert(pRootOfTree.left);
		TreeNode_Convert p = left;
        while(p!=null&&p.right!=null) {
            p=p.right;
        }
        if(left!=null) {
        	p.right = pRootOfTree;
        	pRootOfTree.left=p;
        }
        
        TreeNode_Convert right = convert(pRootOfTree.right);
        if (right!=null) {
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
        
		return left == null ?pRootOfTree:left;
    }
}
class TreeNode_Convert {
	
	int val = 0;
	TreeNode_Convert left = null;
	TreeNode_Convert right = null;
	
	public TreeNode_Convert(int val) {
		super();
		this.val = val;
	}
}