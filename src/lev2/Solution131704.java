package lev2;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/131704
public class Solution131704 {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int orderIndex = 0;
        for (int i = 1; i < order.length + 1; i++) {
            if (order[orderIndex] != i) {
                if (!sub.isEmpty() && order[orderIndex] == sub.peek()) {
                    i--;
                    orderIndex++;
                    sub.pop();
                } else {
                    sub.push(i);
                }
            } else {
                orderIndex++;
            }
        }
        if (!sub.isEmpty() && sub.peek() == order[orderIndex]) {
            for (int i = orderIndex; i < order.length; i++) {
                if (order[i] == sub.peek()) {
                    orderIndex++;
                    sub.pop();
                }
            }
        }
        return orderIndex;
    }

    public static void main(String[] args) {
        int c = new Solution131704().solution(new int[]{5, 4, 3, 2, 1});
        System.out.println(c);
    }
}
