package com.company.Title_7;

public class Solution_1 {
	public static int reverse(int x) {
		int recv = 0;
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (recv > Integer.MAX_VALUE / 10 || (recv == Integer.MAX_VALUE && pop > 7)) {
				recv = 0;
				break;
			} else if (recv < Integer.MIN_VALUE / 10 || (recv == Integer.MIN_VALUE && pop < -8)) {
				recv = 0;
				break;
			}
			recv = recv * 10 + pop;
		}
		return recv;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE % 10);
		System.out.println(Integer.MIN_VALUE % 10);
	}
}
