package com.company.Title_4;

public class Solution_1 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0){
			int length = nums2.length;
			int right = length / 2;
			int left = (length - 1) / 2;
			return (nums2[right] + nums2[left]) / 2.0f;
		}

		if (nums2 == null || nums2.length == 0){
			int length = nums1.length;
			int right = length / 2;
			int left = (length - 1) / 2;
			return (nums1[right] + nums1[left]) / 2.0f;
		}

		if (nums1.length > nums2.length){
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}

		int m = nums1.length;
		int n = nums2.length;

		int minI = 0;
		int maxI = m;

		int i,j;

		int half = (m + n + 1) / 2;

		while (true){
			i = (minI + maxI) / 2;
			j = half - i;
			if (i < maxI && nums2[j - 1] > nums1[i]){
				minI = i + 1;
			} else if (i > minI && nums1[i - 1] >nums2[j]){
				maxI = i - 1;
			} else {
				int maxLeft;
				if (i == 0){
					maxLeft = nums2[j - 1];
				} else if (j == 0){
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i-1], nums2[j-1]);
				}

				if ((m + n) % 2 == 1){
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) { minRight = nums2[j]; }
				else if (j == n) { minRight = nums1[i]; }
				else { minRight = Math.min(nums2[j], nums1[i]); }
				return (maxLeft + minRight) / 2.0;
			}
		}
	}

	public static void main(String[] args){
		int[] nums1 = new int[]{1,2};
		int[] nums2 = new int[]{3,4};
		Solution_1 solution_1 = new Solution_1();
		System.out.println(solution_1.findMedianSortedArrays(nums1, nums2));
	}
}
