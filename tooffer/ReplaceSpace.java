package com.cn.nowcoder1.tooffer;

/*
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("i am Zhangjianwei , haha.");
		
		ReplaceSpace rs = new ReplaceSpace();
		System.out.println(rs.replaceSpace(sBuffer));
		
		System.out.println(rs.replaceSpace2(sBuffer));
		
		System.out.println(rs.replaceSpace3(sBuffer));
	}
	public String replaceSpace(StringBuffer str) {//100%
		if(str==null){
	        return null;
	     }
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%");
				sb.append("2");
				sb.append("0");
			}
			else {
				sb.append(str.charAt(i));
			}
		}
		String str1 = sb.toString();
		return str1;
    }
	public String replaceSpace2(StringBuffer str) {//25%
		
		StringBuffer sb2 = new StringBuffer();
		String[] s = str.toString().split(" ");
		sb2.append(s[0]);
		for (int i = 1; i < s.length; i++) {
			sb2.append("%20");
			sb2.append(s[i]);
		}
		return sb2.toString();
    }
	public String replaceSpace3(StringBuffer str) {//100%
		if(str==null){
	        return null;
	     }
	     for(int i=0;i<str.length();i++){
	         char c = str.charAt(i);
	         if(c==' '){
	            str.replace(i,i+1,"%20");
	         }
	      }
	      String newstr = str.toString();
	      return newstr;   
	}
}
