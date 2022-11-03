package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/76501
public class Solution76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int res = 0;
        for (int i = 0; i < absolutes.length; i++) {
            res = (signs[i]) ? res + absolutes[i] : res - absolutes[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int r = new Solution76501().solution(new int[]{4, 7, 12}, new boolean[]{true, false, true});
        System.out.println(r);
    }
}
