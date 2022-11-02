package lev1;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Solution81301 {
    public int solution(String s) {
        Map<String, Integer> eng = new HashMap<>() {{
           put("zero", 0);
           put("one", 1);
           put("two", 2);
           put("three", 3);
           put("four", 4);
           put("five", 5);
           put("six", 6);
           put("seven", 7);
           put("eight", 8);
           put("nine", 9);
        }};

        String tmp = "";
        StringBuilder result = new StringBuilder();
        for (String t : s.split("")) {
            try {
                Integer.parseInt(t);
                result.append(t);
            } catch (NumberFormatException e) {
                tmp += t;
                if (eng.containsKey(tmp)) {
                    result.append(eng.get(tmp));
                    tmp = "";
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        int n = new Solution81301().solution("23four5six7");
        System.out.println(n);
    }
}
