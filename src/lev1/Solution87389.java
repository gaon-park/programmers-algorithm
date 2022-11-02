package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/87389
public class Solution87389 {
    public int solution(int n) {
        int result = 0;
        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            if (n % i == 1) {
                result = i;
                break;
            }
        }
        if (result == 0) {
            result = n - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = new Solution87389().solution(12);
        System.out.println(n);
    }
}
