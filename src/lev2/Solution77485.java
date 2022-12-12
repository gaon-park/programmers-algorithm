package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/77485
public class Solution77485 {
    static class CustomKey {
        int row;
        int col;

        CustomKey(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof CustomKey) {
                CustomKey c = (CustomKey) o;
                return row == c.row && col == c.col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + j + 1;
            }
        }

        int[] result = new int[queries.length];
        int resultIndex = 0;
        for (int[] query : queries) {
            query[0]--;
            query[1]--;
            query[2]--;
            query[3]--;

            Map<CustomKey, Integer> tmp = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                if (i < query[0] || i > query[2]) continue;
                for (int j = 0; j < columns; j++) {
                    if (j < query[1] || j > query[3]) continue;
                    if (i != query[0] && j > query[1] && i != query[2] && j < query[3]) continue;

                    if (i == query[0] && j < query[3]) {
                        tmp.put(new CustomKey(i, j + 1), map[i][j]);
                    } else if (j == query[3] && i < query[2]) {
                        tmp.put(new CustomKey(i + 1, j), map[i][j]);
                    } else if (i == query[2] && j > query[1]) {
                        tmp.put(new CustomKey(i, j - 1), map[i][j]);
                    } else {
                        tmp.put(new CustomKey(i - 1, j), map[i][j]);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (CustomKey k : tmp.keySet()) {
                int value = tmp.get(k);
                min = Math.min(min, value);
                map[k.row][k.col] = value;
            }
            result[resultIndex++] = min;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] n = new Solution77485().solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        System.out.println(Arrays.toString(n));
    }
}
