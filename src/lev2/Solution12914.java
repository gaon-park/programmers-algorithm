package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class Solution12914 {
    public long solution(int n) {
        long[] ar = new long[2001];
        ar[1] = 1;
        ar[2] = 2;
        for (int i = 3; i <= n; i++) {
            ar[i] = (ar[i - 1] + ar[i - 2]) % 1234567;
        }
        return ar[n];
    }
}
