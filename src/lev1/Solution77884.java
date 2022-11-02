package lev1;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class Solution77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int tmp = i;
            int j = 2;
            Map<Integer, Integer> map = new HashMap<>();
            while (tmp != 1) {
                if (tmp % j == 0) {
                    tmp /= j;
                    if (map.get(j) != null) {
                        map.put(j, map.get(j) + 1);
                    } else {
                        map.put(j, 1);
                    }
                } else {
                    j++;
                }
            }
            int count = 1;
            for (Integer v : map.values()) {
                count *= (v + 1);
            }
            answer = (count % 2 == 0) ? answer + i : answer - i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = new Solution77884().solution(24, 27);
        System.out.println(a);
    }
}
