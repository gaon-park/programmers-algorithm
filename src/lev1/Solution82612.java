package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class Solution82612 {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for (long i = 1; i <= count; i++) {
            sum += (long) price * i;
        }
        return (money - sum < 0) ? Math.abs(money - sum) : 0;
    }

    public static void main(String[] args) {
        long s = new Solution82612().solution(3, 20, 4);
        System.out.println(s);
    }
}
