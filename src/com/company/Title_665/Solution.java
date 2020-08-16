package com.company.Title_665;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean result = true;
        if (nums == null || nums.length <= 2){
            return result;
        }
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i ++){
            if (nums[i] > nums[i + 1]){
                int left, right;
                left = (i > 0) ? nums[i - 1] : nums[i];
                right = i + 2 < nums.length ? nums[i + 2] : nums[i + 1];


                if (temp == 1){
                    result = false;
                    break;
                }
                nums[i + 1] = (i > 0) ? nums[i] : nums[i + 1];
                i --;
                temp = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
    }
}
