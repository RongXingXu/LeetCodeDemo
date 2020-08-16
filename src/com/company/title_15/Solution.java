package com.company.title_15;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
// 👍 2470 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int first = 0;first < length; first ++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            if (nums[first] > 0){
                break;
            }
            // 注意时间复杂度，third 放这儿是因为没有必要第二轮枚举third每次都初始化一遍
            // second一定是递增的，当一个三轮枚举完成，第二轮second递增，third一定要比之前小
            int third = length - 1;
            for (int second = first + 1; second < length; second ++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                for (;third > second; third --){
                    int sum = nums[first] + nums[second] + nums[third];
                    if (sum == 0){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[first]);
                        integers.add(nums[second]);
                        integers.add(nums[third]);
                        result.add(integers);
                        break;
                    } else if (sum < 0) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
