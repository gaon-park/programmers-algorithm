package lev2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/87377
public class Solution87377 {
    static class PointC {
        long x;
        long y;

        public PointC(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof PointC) {
                PointC p = (PointC) o;
                return x == p.x && y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public String[] solution(int[][] line) {
        Set<PointC> set = new HashSet<>();
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (i == j) continue;
                double com = (line[i][0] * line[j][1] - line[i][1] * line[j][0]);

                double x = ((long) line[i][1] * line[j][2] - (long) line[i][2] * line[j][1]) / com;
                double y = ((long) line[i][2] * line[j][0] - (long) line[i][0] * line[j][2]) / com;

                if ((long) x == x && (long) y == y) {
                    set.add(new PointC((long) x, (long) y));
                    long longX = (long) x, longY = (long) y;
                    maxX = Math.max(maxX, longX);
                    maxY = Math.max(maxY, longY);
                    minX = Math.min(minX, longX);
                    minY = Math.min(minY, longY);
                }
            }
        }

        String[] result = new String[(int) (maxY - minY + 1)];
        for (long i = maxY, indexI = 0; i >= minY; i--, indexI++) {
            StringBuilder sb = new StringBuilder();
            for (long j = minX; j <= maxX; j++) {
                if (set.contains(new PointC(j, i))) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            result[(int) indexI] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        String[] s = new Solution87377().solution(new int[][]{
                {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        });
        for (String st : s) {
            System.out.println(st);
        }
    }
}
