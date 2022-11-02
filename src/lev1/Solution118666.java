package lev1;

import java.util.HashMap;
import java.util.Map;

public class Solution118666 {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> result = new HashMap<>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};

        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        String key = "";
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] == 4) continue;
            // 비동의 항목
            if (choices[i] < 4) {
                key = survey[i].split("")[0];
            }
            // 동의 항목
            else if (choices[i] > 4) {
                key = survey[i].split("")[1];
            }
            result.put(key, result.get(key) + score[choices[i]]);
        }

        return subSolution(result);
    }

    public String subSolution(Map<String, Integer> map) {
        String result = (map.get("R").compareTo(map.get("T")) >= 0) ? "R" : "T";
        result += (map.get("C").compareTo(map.get("F")) >= 0) ? "C" : "F";
        result += (map.get("J").compareTo(map.get("M")) >= 0) ? "J" : "M";
        result += (map.get("A").compareTo(map.get("N")) >= 0) ? "A" : "N";
        return result;
    }

    public static void main(String[] args) {
        String s = new Solution118666().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println(s);
    }
}
