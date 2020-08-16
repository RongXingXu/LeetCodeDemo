package com.company.Title_6;

public class Solution_1 {
	public static String convert(String s, int numRows) {
		if (s == null || s.length() == 0){
			return "";
		}
		if(numRows == 1){
			return s;
		}
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i ++){
			sbs[i] = new StringBuilder();
		}
		for(int i = 0; i < s.length(); i = i + (numRows - 1) * 2){
			int index = 0;
			boolean up = true;
			for (int j = i;j < i + (numRows - 1) * 2 && j < s.length(); j ++){
				sbs[index].append(s.charAt(j));
				if (up){
					index ++;
				} else {
					index --;
				}
				if (index == numRows){
					up = false;
					index = index - 2;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (StringBuilder sb : sbs){
			result.append(sb);
		}
		return result.toString();
	}

	// 分段处理

	public static void main(String[] args){
		System.out.println(convert("LEETCODEISHIRING", 4));
	}


}
