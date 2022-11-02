package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Solution86491 {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            w = Math.max(w, max);
            h = Math.max(h, min);
        }

        return w * h;
    }

    public static void main(String[] args) {
        int s = new Solution86491().solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(s);
    }
}
