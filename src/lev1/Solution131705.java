package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/131705
public class Solution131705 {
    public int solution(int[] number) {
        int count = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    count = (number[i] + number[j] + number[k] == 0) ? count + 1 : count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int res = new Solution131705().solution(new int[] {-1, 1, -1, 1});
        System.out.println(res);
    }
}
