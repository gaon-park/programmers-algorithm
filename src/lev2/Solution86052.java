package lev2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/86052
public class Solution86052 {
    // 위, 오른, 아래, 왼
    int[][] directs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int I;
    int J;
    int[][][] visited;

    public int cycle(String[] grid, int i, int j, int d) {
        // 이동 거리
        int count = 0;

        while (visited[i][j][d] != 1) {
            count++;
            visited[i][j][d] = 1;

            if (grid[i].charAt(j) == 'L') {
                d = (d + 3) % 4;
            } else if (grid[i].charAt(j) == 'R') {
                d = (d + 1) % 4;
            }

            i = (i + directs[d][0] + I) % I;
            j = (j + directs[d][1] + J) % J;
        }

        return count;
    }

    public int[] solution(String[] grid) {
        I = grid.length;
        J = grid[0].length();
        visited = new int[I][J][4];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                for (int d = 0; d < 4; d++) {
                    if (visited[i][j][d] == 0) {
                        list.add(cycle(grid, i, j, d));
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] n = new Solution86052().solution(new String[]{"SL", "LR"});
        System.out.println(Arrays.toString(n));
    }
}
