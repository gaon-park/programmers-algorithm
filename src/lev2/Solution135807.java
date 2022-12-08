package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/135807
public class Solution135807 {
    public List<Integer> getDivisor(List<Integer> list) {
        Collections.sort(list);
        List<Integer> result = new ArrayList<>();
        for (int i = list.get(0); i > 1; i--) {
            boolean flg = true;
            for (int integer : list) {
                if (integer % i != 0) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                result.add(i);
            }
        }
        return result;
    }

    public int search(List<Integer> base, List<Integer> compare) {
        int max = 0;
        for (int b : base) {
            boolean flg = true;
            for (int c : compare) {
                if (c % b == 0) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                max = Math.max(max, b);
            }
        }
        return max;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < arrayA.length; i++) {
            a.add(arrayA[i]);
            b.add(arrayB[i]);
        }

        List<Integer> aList = new ArrayList<>(a);
        List<Integer> bList = new ArrayList<>(b);

        return Math.max(search(getDivisor(aList), bList), search(getDivisor(bList), aList));
    }

    public static void main(String[] args) {
        int n = new Solution135807().solution(new int[]{10, 20}, new int[]{5, 17});
        System.out.println(n);
    }
}
