package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335
public class Solution92335 {
    public int isPrime(long n) {
        if (n < 2) return 0;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return 0;
        }
        return 1;
    }

    public int solution(int n, int k) {
        int count = 0;
        for (String s : Integer.toString(n, k).split("0")) {
            if (s.isEmpty()) continue;
            count += isPrime(Long.parseLong(s));
        }

        return count;
    }

    public static void main(String[] args) {
        int n = new Solution92335().solution(110011, 10);
        System.out.println(n);
    }
}