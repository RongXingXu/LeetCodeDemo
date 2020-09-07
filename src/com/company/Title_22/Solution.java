package com.company.Title_22;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1280 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public static List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        if (n == 0){
//            return result;
//        }
//
//        backtrack(result, 0, n * 2, new StringBuilder());
//
//        return result;
//    }
//
//    public static void backtrack(List<String> result, int index, int len, StringBuilder temp){
//        if (index == len){
//            if (isValid(temp)) {
//                result.add(temp.toString());
//            }
//        } else {
//            temp.append("(");
//            backtrack(result, index + 1, len, temp);
//            temp.deleteCharAt(index);
//
//            temp.append(")");
//            backtrack(result, index + 1, len, temp);
//            temp.deleteCharAt(index);
//
//        }
//
//    }
//
//    public static boolean isValid(StringBuilder temp){
//        boolean result = false;
//        if (temp.length() % 2 == 0 && temp.charAt(0) == '(' && temp.charAt(temp.length() - 1) == ')'){
//            int left = 0;
//            int right = 0;
//            for (int i = 0; i < temp.length(); i ++){
//                char c = temp.charAt(i);
//                if (c == '('){
//                    left ++;
//                } else {
//                    right ++;
//                }
//                if (left < right){
//                    break;
//                }
//            }
//            result = left == right;
//        }
//        return result;
//    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);

        for (String s : result){
            System.out.println(s);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
