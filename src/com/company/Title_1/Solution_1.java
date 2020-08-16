package com.company.Title_1;

public class Solution_1 {

	// 适用数组已经升序的case
	public static int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		if (length < 2) {
			return null;
		}
		int[] result = new int[]{0, 0};
		int half = target / 2;
		for (; result[1] < nums.length; result[1]++) {
			if (nums[result[1]] > half) {
				break;
			}
		}
		result[0] = result[1] - 1;
		if (result[0] < 0 || result[1] > (length - 1)) {
			return null;
		}
		do {
			int temp = target - nums[result[1]];
			if (temp == nums[result[0]]) {
				return result;
			} else if (temp <= nums[result[0]]) {
				result[0]--;
			} else {
				result[1]++;
			}
		} while (result[0] >= 0 && result[1] <= (length - 1));
		if ((nums[result[0]] + nums[result[1]]) == target) {
			return result;
		}
		return null;
	}

	public int[] twoSum1(int[] nums, int target) {
		if (nums.length < 2) {
			return null;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < (nums.length - i - 1); j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int temp = nums[left] + nums[right];
			if (temp == target) {
				return new int[]{
					  left, right
				};
			} else if (temp < target) {
				left++;
			} else {
				right--;
			}
		}
		return null;
	}

	// [3,2,4]
	// [3,3]
	// [2,7,11,15]
	public int[] twoSum2(int[] nums, int target) {
		if (nums.length < 2) {
			return null;
		}
		int length = nums.length;
		int[] temp = new int[length];

		for (int i = 0; i < length; i++) {
			int left = target - nums[i];
			for (int j = 0; j < i; j++) {
				if (nums[i] == temp[j]) {
					return new int[]{
						  j, i
					};
				}
			}
			temp[i] = left;
		}
		return null;
	}

// 数组[] length 是变量，不是函数。 错误使用方式：length()
// 创建数组[]对象 是new int[]{}。 错误使用方式：new int[](){}

// 时间O(n^2)
}
