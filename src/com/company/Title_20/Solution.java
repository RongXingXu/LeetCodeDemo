package com.company.Title_20;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1801 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static boolean isValid2(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        int length = s.length();
        int count = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = 0; i < length; i ++){
            char c = s.charAt(i);
            char sub = getSub(c);
            if (!integers.isEmpty() && s.charAt(integers.get(count - 1)) == sub){
                integers.remove(integers.get(count - 1));
                count --;
                continue;
            }
            integers.add(i);
            count ++;
        }
        return count == 0;
    }

    public static char getSub(char c){
        switch (c){
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        int length = s.length();
        int count = 0;
        ArrayList<Short> chars = new ArrayList<>();
        for(int i = 0; i < length; i ++){
            char c = s.charAt(i);
            char sub = getSub(c);
            if (!chars.isEmpty() && chars.get(count - 1) == sub){
                chars.remove(count - 1);
                count --;
                continue;
            }
            chars.add((short) c);
            count ++;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isValid("()"));
        System.out.println(Solution.isValid("()[]{}"));
        System.out.println(Solution.isValid("(]{}"));
        System.out.println(Solution.isValid("([)]"));
        System.out.println(Solution.isValid("({})"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
