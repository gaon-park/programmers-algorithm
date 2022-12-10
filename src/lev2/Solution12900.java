package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12900
public class Solution12900 {
    public int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int p = 1, q = 2;
        for (int i = 1; i < n - 1; i++) {
            int tmp = p;
            p = q;
            q = (tmp + q) % 1000000007;
            System.out.println(q);
        }
        return q % 1000000007;
    }

    public static void main(String[] args) {
        int n = new Solution12900().solution(10);
        System.out.println(n);
    }
}
