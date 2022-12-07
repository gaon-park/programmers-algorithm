package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
public class Solution138476 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tangerine) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int count = 0;
        for (int key : list) {
            if (k <= 0) break;
            k -= map.get(key);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = new Solution138476().solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println(n);
    }
}
