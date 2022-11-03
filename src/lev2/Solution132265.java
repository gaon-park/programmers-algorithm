package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265
public class Solution132265 {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for (int i : topping) {
            stack.push(i);
            map.merge(i, 1, Integer::sum);
        }

        int count = 0;
        while (!stack.isEmpty()) {
            int key = stack.pop();
            set.add(key);
            map.merge(key, -1, Integer::sum);
            if (map.get(key) == 0) {
                map.remove(key);
            }
            if (map.size() == set.size()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int c = new Solution132265().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        System.out.println(c);
    }
}
