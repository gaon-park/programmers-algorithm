package lev2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/131130
public class Solution131130 {
    public int[] choice(int[] cards, int[] check, int num) {
        check[num] = 1;
        int index = cards[num] - 1;
        while (check[index] == 0) {
            check[index] = 1;
            index = cards[index] - 1;
        }

        return check;
    }

    public int count(int[] check) {
        int count = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1) count++;
        }
        return count;
    }

    public int solution(int[] cards) {
        int max = 0;
        for (int i = 0; i < cards.length; i++) {
            int[] check = choice(cards, new int[cards.length], i);
            int box1 = count(check);
            for (int j = 1; j < cards.length; j++) {
                if (i == j) continue;
                int[] subCheck = Arrays.copyOf(check, check.length);
                subCheck = choice(cards, subCheck, j);
                int box2 = count(subCheck) - box1;
                max = Math.max(max, box1 * box2);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = new Solution131130().solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
        System.out.println(n);
    }
}
