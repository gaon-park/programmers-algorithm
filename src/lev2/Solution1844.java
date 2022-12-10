package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class Solution1844 {
    public int bfs(int[][] maps) {
        ArrayDeque<Integer[]> que = new ArrayDeque<>();
        int[] visited = new int[maps.length * maps[0].length];
        que.add(new Integer[]{0, 0, 1});

        while (!que.isEmpty()) {
            Integer[] q = que.poll();

            int i = q[0], j = q[1], distance = q[2];
            if (maps[i][j] == 0) continue;
            maps[i][j] = 0;

            if (i == maps.length - 1 && j == maps[0].length - 1) {
                return q[2];
            }

            // up
            if (i > 0 && maps[i - 1][j] > 0) {
                que.add(new Integer[]{i - 1, j, distance + 1});
            }
            // down
            if (i < maps.length - 1 && maps[i + 1][j] > 0) {
                que.add(new Integer[]{i + 1, j, distance + 1});
            }
            // right
            if (j < maps[i].length - 1 && maps[i][j + 1] > 0) {
                que.add(new Integer[]{i, j + 1, distance + 1});
            }
            // left
            if (j > 0 && maps[i][j - 1] > 0) {
                que.add(new Integer[]{i, j - 1, distance + 1});
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public static void main(String[] args) {
        int n = new Solution1844().solution(
                new int[][]
//                        {
//                                {1, 0, 1, 1, 1},
//                                {1, 0, 1, 0, 1},
//                                {1, 0, 1, 1, 1},
//                                {1, 1, 1, 0, 0},
//                                {0, 0, 0, 0, 1}
//                        }
                        {
                                {1, 0, 1, 1, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1},
                                {1, 1, 1, 0, 1},
                                {0, 0, 0, 0, 1}
                        }
        );
        System.out.println("res: " + n);
    }
}
