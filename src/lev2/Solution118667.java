package lev2;

import java.util.ArrayDeque;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class Solution118667 {
    public int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0;
        for (int i : queue1) {
            sum1 += i;
            q.add(i);
        }
        for (int i : queue2) {
            sum2 += i;
        }
        long target = (sum1 + sum2) / 2;
        int index = 0;
        int count = 0;
        while (index < queue2.length && !q.isEmpty()) {
            if (sum1 == target) break;
            if (sum1 < target) {
                q.add(queue2[index]);
                sum1 += queue2[index++];
            } else {
                sum1 -= q.poll();
            }
            count++;
        }
        if (sum1 != target) return -1;

        return count;
    }

    public static void main(String[] args) {
        int n = new Solution118667().solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println(n);
    }
}
