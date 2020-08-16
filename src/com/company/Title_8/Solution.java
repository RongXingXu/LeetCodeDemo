package com.company.Title_8;

class Solution {
	public static int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		int index = 0;
		int len = str.length();
		if (str != null && len > 0) {
			char first = str.charAt(index);
			if (first == '-' || first == '+' || (str.charAt(index) >= '0' && str.charAt(index) <= '9')) {
				index++;
				while (index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
					index++;
				}
			}
		}
		if (index > 0){
			try {
				result = Integer.valueOf(str.substring(0, index));
			} catch (NumberFormatException e){
				result = Integer.MAX_VALUE;
				result = Integer.MIN_VALUE;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-91283472332"));
	}
}
