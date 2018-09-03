package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张建伟
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class reOrderArray {

	public void solution(int [] array) {
		
		for(int i= 0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	public void solution2(int [] array) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i]%2==1) {
				list1.add(array[i]);
			}
			if (array[i]%2==0) {
				list2.add(array[i]);
			}
		}
		list1.addAll(list2);
		for (Integer integer : list1) {
			System.out.print(integer+" ");
		}
	}
	public static void main(String[] args) {
		int array[] = {1,5,8,4,6,48,2,6,42,448,5,5};
		reOrderArray roa = new reOrderArray();
		roa.solution(array);
		System.out.println();
		roa.solution2(array);
	}
}
