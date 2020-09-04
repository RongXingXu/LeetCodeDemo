package com.company.Title_17;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法
// 👍 843 👎 0


import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    //穷举
    public static List<String> letterCombinations1( String digits) {
        List<String> result = new ArrayList<>();
        int len = digits.length();

        for (int i = 0; i < len; i ++){
            int num = digits.charAt(i) - '0';
            List<String> temp = new ArrayList<>();
            String letterStr = letterMap[num];
            for (int j = 0; j < letterStr.length(); j ++){
                char l = letterStr.charAt(j);
                if (result.isEmpty()){
                    for (int k = 0; k < letterStr.length(); k ++){
                        char m = letterStr.charAt(k);
                        temp.add(m + "");
                    }
                    break;
                }
                for (String s : result){
                    s = s + l;
                    temp.add(s);
                }
            }
            result = temp;
        }
        return result;
    }

    //递归的方式再写一遍
    public static List<String> letterCombinations( String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0){
            return result;
        }
        int len = digits.length();
        backtrack(result, 0, digits, new StringBuilder());
        return result;
    }

    public static void backtrack(List<String> result, int index, String digits, StringBuilder temp){
        if (index == digits.length()){
            result.add(temp.toString());
        } else {
            String num = letterMap[digits.charAt(index) - '0'];
            for (int i = 0; i < num.length(); i ++){
                temp.append(num.charAt(i));
                backtrack(result, index + 1, digits, temp);
                temp.deleteCharAt(index);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
