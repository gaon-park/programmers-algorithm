package lev1;

public class Solution132267 {
    // a: 마트에 주어야 하는 병 수
    // b: 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수
    // n: 상빈이가 가지고 있는 빈 병의 개수
    public int solution(int a, int b, int n) {
        if (a > n) return 0;
        return n / a * b + solution(a, b, n / a * b + n % a);
    }

    public static void main(String[] args) {
        System.out.println(new Solution132267().solution(2, 1, 20));
    }
}
