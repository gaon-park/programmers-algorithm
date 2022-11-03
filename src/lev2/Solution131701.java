package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class Solution131701 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (int size = 1; size < elements.length + 1; size++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int x = i; x < i + size; x++) {
                    sum +=  (x >= elements.length) ? elements[x % elements.length] : elements[x];
                }
                set.add(sum);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int i = new Solution131701().solution(new int[]{7, 9, 1, 1, 4});
        System.out.println(i);
    }
}
