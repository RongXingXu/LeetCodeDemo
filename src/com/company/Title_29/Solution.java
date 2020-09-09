package com.company.Title_29;
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 数学 二分查找
// 👍 410 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int divide(int dividend, int divisor) {
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            } else {
                return - dividend;
            }
        }

        long a = dividend;
        long b = divisor;

        if (a > 0 && b > 0){
            return fun2(a, b);
        } else if (a < 0 && b < 0){
            return fun2(-a, -b);
        } else {
            return - fun2(Math.abs(a), Math.abs(b));
        }
    }

    public static int fun(long dividend, long divisor) {
        if (dividend < divisor){
            return 0;
        }
        int result = 0;
        long tb = divisor;
        int count = 1;
        for (; (dividend - tb) >= 0; ) {
            dividend -= tb;
            result += count;
            tb = tb + tb;
            count += count;
        }
        return result + fun(dividend, divisor);
    }

    //TODO 位运算做一遍
    public static int fun2(long dividend, long divisor) {
        if (dividend < divisor){
            return 0;
        }
        int i = 0;
        while (dividend >= divisor << i){
            i ++;
        }
        i --;

        int result = (1 << i) + fun2(dividend - (divisor << i), divisor);
        System.out.println(result);
        return result;

//        // 如果小于，就无法放置任何
//        if(a < b) return 0;
//
//        int i = 0;
//        while( a >= (b<<i) ){
//            i++;
//        }
//        i--;
//
//        return (1<<i) + fun2(a - (b<<i) , b);
    }

    public static void main(String[] args) {
//        System.out.println(divide(10, 2));
        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(-1, -1));
        System.out.println(divide(-2147483648, 2));

        System.out.println(1 << 2 + 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
