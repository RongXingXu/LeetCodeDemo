//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 551 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE - Math.abs(target) - 1;

        Arrays.sort(nums);
        int length = nums.length;

        for (int first = 0;first < length; first ++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
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
                    if (sum == target){
                        result = sum;
                        break;
                    } else if (sum < target) {
                        result = (Math.abs(sum - target) < Math.abs(result - target)) ? sum : result;
                        break;
                    }
                    result = (Math.abs(sum - target) < Math.abs(result - target)) ? sum : result;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
