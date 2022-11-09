package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class Solution131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                list.add(want[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < discount.length - list.size() + 1; i++) {
            List<String> tmp = new ArrayList<>(list);
            for (int j = i; j < i + list.size(); j++) {
                if (!tmp.contains(discount[j])) break;
                tmp.remove(discount[j]);
            }
            if (tmp.isEmpty()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = new Solution131127().solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        System.out.println(n);
    }
}
