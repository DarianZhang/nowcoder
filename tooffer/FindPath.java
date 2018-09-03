package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;

/**
 * @author �Ž�ΰ
 * �������к�Ϊĳһֵ��·��
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 */

class TreeNode34 {
    int val = 0;
    TreeNode34 left = null;
    TreeNode34 right = null;

    public TreeNode34(int val) {
        this.val = val;
    }
}
public class FindPath {
	/*
	 * һ
	 */
	public ArrayList<ArrayList<Integer>> findPath(TreeNode34 root,int target) {
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        int sum = 0;
        
        pa(root, target, arr, list1, sum);
		return arr;
    }

	public void pa(TreeNode34 root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
		if (root == null)
			return;
		sum += root.val;
		if (root.left == null && root.right == null) {
			if (sum == target) {
				a1.add(root.val);
				arr.add(new ArrayList<Integer>(a1));
				a1.remove(a1.size() - 1);
			}
			return;
		}
		a1.add(root.val);
		pa(root.left, target, arr, a1, sum);
		pa(root.right, target, arr, a1, sum);
		a1.remove(a1.size() - 1);
	}
	/*
	 * ��
	 */
	private ArrayList<ArrayList<Integer>> arrall = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> findPath2(TreeNode34 root,int target) {
		
		if (root == null) {
			return arrall;
		}
		arrayList.add(root.val);
		target -= root.val;
		
		if (target == 0&&root.left == null&&root.right == null) {
			arrall.add(new ArrayList<Integer>(arrayList));
		}
		findPath2(root.left, target);
		findPath2(root.right, target);
		arrayList.remove(arrayList.size()-1);
		return arrall;
	}
}
