package com.company.Title_31;

//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须原地修改，只允许使用额外常数空间。
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
// Related Topics 数组
// 👍 651 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//算法推导
//        如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
//
//        1、我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
//        2、我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
//              a、在尽可能靠右的低位进行交换，需要从后向前查找
//              b、将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
//              c、将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
//        以上就是求“下一个排列”的分析过程。
class Solution {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 1){
            return;
        }

        int i = len - 2;
        for (; i >= 0; i --){
            if (nums[i] < nums[i + 1]){
                break;
            }
        }

        if (i >= 0) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }

        for (int k = i + 1; k < len; k ++){
            for (int l = len - 1; l > k; l --){
                if (nums[l] < nums[l - 1]){
                    int temp = nums[l];
                    nums[l] = nums[l - 1];
                    nums[l - 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        for (int i: nums) {
            System.out.print(i);
        }
        System.out.println();

        nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int i: nums) {
            System.out.print(i);
        }
        System.out.println();

        nums = new int[]{1,3,2};
        nextPermutation(nums);
        for (int i: nums) {
            System.out.print(i);
        }
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
