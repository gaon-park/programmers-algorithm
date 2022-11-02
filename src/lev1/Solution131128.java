package lev1;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131128
public class Solution131128 {
    public String solution(String x, String y) {
        List<String> listX = new ArrayList<>(Arrays.asList(x.split("")));
        List<String> listY = new ArrayList<>(Arrays.asList(y.split("")));
        String[] arr = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (listX.contains(s) && listY.contains(s)) {
                int count = Math.min(Collections.frequency(listX, s), Collections.frequency(listY, s));
                sb.append(s.repeat(count));
            }
        }

        String result = sb.toString();
        if (result.length() == 0) return "-1";
        if (result.replace("0", "").length() == 0) return "0";
        return result;
    }

    public static void main(String[] args) {
        String s = new Solution131128().solution("100", "203045");
        System.out.println(s);
    }
}
