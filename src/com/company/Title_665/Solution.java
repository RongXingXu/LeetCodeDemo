package com.company.Title_665;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i ++){
            if (nums[i] <= nums[i + 1]){
                continue;
            }
            count ++;
            if (i == 0){
                nums[i] = nums[i + 1];
            } else {
                if (nums[i - 1] > nums[i + 1]){
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
    }
}
