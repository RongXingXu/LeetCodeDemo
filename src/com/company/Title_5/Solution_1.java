package com.company.Title_5;

class Solution_1 {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i ++){
			int len1 = maxLength(s, i, i);
			int len2 = maxLength(s, i , i + 1);
			int len = Math.max(len1, len2);
			if(len > (end - start)){
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	public static int maxLength(String s, int left, int right){
		int L = left;
		int R = right;
		while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
			L --;
			R ++;
		}
		return R - L - 1;
	}

	public static void main(String[] args){
		String test = "ababd";
		System.out.println(longestPalindrome(test));
	}

	// 解法一： 暴力搜素，找出所有的子串，判断子串是否为回文字符串 O（n^3）
	// 解法二： 找S和S'的最长重复子串，需要判断位置，位置应该是对称关系
	// 解法三： 中心扩展算法
}
