package com.company.Title_1295;

public class Solution_1 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for(int i : nums){
            if ((i > 9 && i < 100) || (i > 999 && i < 10000) || i == 100000){
                result ++;
            }
        }
        return result;
    }
}
