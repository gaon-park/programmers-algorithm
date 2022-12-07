package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/140107
public class Solution140107 {
    public long solution(int k, int d) {
        // 0, 0
        long count = 1;
        for (long i = k; i <= d; i += k) {
            // x축, y축
            count += 2;

            // 축에 접하지 않음
            long y = (long) Math.floor(Math.sqrt(((long) d * d) - (i * i)));
            count += y / k;
        }

        return count;
    }

    public static void main(String[] args) {
        long n = new Solution140107().solution(1, 5);
        System.out.println(n);
    }
}
