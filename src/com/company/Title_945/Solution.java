package com.company.Title_945;

import java.util.Arrays;
/*
*
* 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
* 返回使 A 中的每个值都是唯一的最少操作次数。
*
* 示例 1:
* 输入：[1,2,2]
* 输出：1
* 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
*
* 示例 2:
* 输入：[3,2,1,2,1,7]
* 输出：6
* 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
* 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
*
* 提示：
* 0 <= A.length <= 40000
* 0 <= A[i] < 40000
*
*
* step 1 排序
* step 2 当我们找到一个没有出现过的数的时候，将之前某个重复出现的数增加成这个没有出现过的数。
* 注意，这里 「之前某个重复出现的数」 是可以任意选择的，它并不会影响最终的答案，因为将 P 增加
* 到 X 并且将 Q 增加到 Y，与将 P 增加到 Y 并且将 Q 增加到 X 都需要进行 (X + Y) - (P + Q)
* 次操作。
* 例如当数组 A 为 [1, 1, 1, 1, 3, 5] 时，我们发现有 3 个重复的 1，且没有出现过 2，4 和 6，
* 因此一共需要进行 (2 + 4 + 6) - (1 + 1 + 1) = 9 次操作。
* */
public class Solution {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int same = 0;
        int result = 0;
        for(int i = 1; i < A.length; i ++){
            if (A[i - 1] == A[i]){
                same ++;
                result -= A[i];
            } else {
                int temp = Math.min(same, A[i] - A[i - 1] - 1);
                same -= temp;
                result = result + temp * (temp + 1) / 2 + temp * A[i - 1];
            }
        }

        if (same > 0){
            result = result + same * (same + 1) / 2 + same * A[A.length - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(solution.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}
