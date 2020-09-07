package com.company.Title_18;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针
// 👍 538 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int first = 0; first < length; first ++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            for (int second = first + 1; second < length; second ++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                int four = length - 1;
                for (int third = second + 1; third < length; third ++){
                    if (third > second + 1 && nums[third] == nums[third - 1]){
                        continue;
                    }
                    for (;four > third; four --){
                        int sum = nums[first] + nums[second] + nums[third] + nums[four];
                        if (sum == target){
                            List<Integer> integers = new ArrayList<>();
                            integers.add(nums[first]);
                            integers.add(nums[second]);
                            integers.add(nums[third]);
                            integers.add(nums[four]);
                            result.add(integers);
                            break;
                        } else if (sum < target) {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
