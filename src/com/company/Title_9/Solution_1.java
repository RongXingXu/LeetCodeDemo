package com.company.Title_9;

class Solution {
	public boolean isPalindrome2(int x) {
		if (x < 0){
			return false;
		}
		boolean result = true;
		String temp = String.valueOf(x);
		int length = temp.length();
		for(int i = 0; i < length / 2; i ++){
			if(temp.charAt(i) != temp.charAt(length - 1 - i)){
				result = false;
				break;
			}
		}
		return result;
	}


	public boolean isPalindrome1(int x) {
		if (x < 0){
			return false;
		}
		boolean result = true;
		int temp = x;
		int temp1 = 0;
		while(temp != 0){
			int sub = temp % 10;
			temp = temp / 10;
			temp1 = temp1 * 10 + sub;
		}
		result = temp1 == x;
		return result;
	}

	// 最优
	public boolean isPalindrome(int x) {
		if(x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		boolean result = true;
		int temp = x;
		int temp1 = 0;
		while(temp1 < temp){
			int sub = temp % 10;
			temp = temp / 10;
			temp1 = temp1 * 10 + sub;
		}
		result = temp1 == temp || temp1 / 10 == temp;
		return result;
	}
	/*
	* 解法有三种：
	* 1、转字符串判断字符串是不是回文
	* 2、数字反转，判断是否相等
	* 3、基于2，但是只反转一半，比如1221，我们只反转21（12）和12比较，相等就是回文
	*     这里要考虑位数是基数的场景，比如121，这里只需要退一步，比较1==1就可以
	*     然后就是10，只有两位的场景，他满足位数为基数的场景条件，但是要排除掉
	* */
}
