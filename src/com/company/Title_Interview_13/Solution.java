package com.company.Title_Interview_13;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* DFS 和 BFS思想
* */

public class Solution {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    int dfs(int i, int j, int si, int sj){
        if (i >= m || j >= n || si + sj > k || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj)
                + dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
    }

    int bfs(int m, int n, int k){
        boolean[][] visited = new boolean[m][n];
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, 0});
        int result = 0;
        while (!queue.isEmpty()){
            int[] ints = queue.poll();
            int i = ints[0], j = ints[1], si = ints[2], sj = ints[3];
            if (i >= m || j >= n || si + sj > k || visited[i][j]){
                continue;
            }
            result ++;
            visited[i][j] = true;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1});
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount(3, 1, 0));
        System.out.println(solution.movingCount(6, 18, 4));
        System.out.println(solution.movingCount(16, 8, 4));
        System.out.println(solution.movingCount(38, 15, 9));

        System.out.println(solution.bfs(2, 3, 1));
        System.out.println(solution.bfs(3, 1, 0));
        System.out.println(solution.bfs(6, 18, 4));
        System.out.println(solution.bfs(16, 8, 4));
        System.out.println(solution.bfs(38, 15, 9));
    }
}
