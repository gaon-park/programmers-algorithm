package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085
public class Solution142085 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> defense = new PriorityQueue<>();
        int i;
        for (i = 0; i < enemy.length; i++) {
            if (defense.isEmpty() || defense.size() < k) {
                defense.add(enemy[i]);
            }
            else {
                if (defense.peek() < enemy[i] && n - defense.peek() >= 0) {
                    n -= defense.poll();
                    defense.add(enemy[i]);
                } else if (n - enemy[i] >= 0) {
                    n -= enemy[i];
                } else {
                    break;
                }
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int n = new Solution142085().solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        System.out.println(n);
    }
}
