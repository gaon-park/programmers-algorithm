package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Solution87946 {
    public int clear(int k, int[][] dungeons, int[] done, int index) {
        done[index] = 1;
        k -= dungeons[index][1];
        int count = count(done);
        for (int i = 0; i < done.length; i++) {
            if (i != index && done[i] == 0 && dungeons[i][0] <= k) {
                count = Math.max(count, clear(k, dungeons, done, i));
                done[i] = 0;
            }
        }
        return count;
    }

    public int count(int[] done) {
        int count = 0;
        for (int d : done) {
            if (d == 1) count++;
        }
        return count;
    }

    public int solution(int k, int[][] dungeons) {
        int max = 0;
        for (int i = 0; i < dungeons.length; i++) {
            int[] done = new int[dungeons.length];
            int count = clear(k, dungeons, done, i);
            max = Math.max(max, count);
            if (max == dungeons.length) break;
        }
        return max;
    }

    public static void main(String[] args) {
        int n = new Solution87946().solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(n);
    }
}
