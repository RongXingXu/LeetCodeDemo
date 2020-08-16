package com.company.Title_3;

public class Solution_1 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int result = 0;

        int startIndex = 0;
        int endIndex = 0;

        int[] state = new int[256];
        for (int i = 0; i < 256; i ++){
            state[i] = -1;
        }
        char c;
        do {
            c = s.charAt(endIndex);
            if (state[c] != -1){
                int preIndex = state[c];
                if (startIndex <= preIndex){
                    int len = endIndex - startIndex;
                    result = result > len ? result : len;
                    startIndex = preIndex + 1;
                }
            }
            state[c] = endIndex;
            endIndex ++;
        }while (endIndex < s.length());
        if (result < (endIndex - startIndex)){
            result = endIndex - startIndex;
        }
        return result;
    }



    public static int lengthOfLongestSubstring1(String s) {
        int length = 1;
        int startIndex = 0, endIndex = 1;
        if (s == null || s.length() == 0){
            return 0;
        }

        while (endIndex < s.length()){
            String temp = s.substring(startIndex, endIndex);

            char c = s.charAt(endIndex);

            int i = temp.indexOf(c);
            if (i == -1){
                length = length > temp.length() + 1 ? length : temp.length() + 1;
                endIndex ++;
            } else {
                startIndex = startIndex + i + 1;
                endIndex ++;
            }
        }
        return length;
    }










































































}
