package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/64065
public class Solution64065 {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] split = s.split("");
        for (int i = 1; i < split.length - 1; i++) {
            if (split[i].equals("{") || split[i].equals(",")) continue;
            do {
                StringBuilder tmp = new StringBuilder();
                while (!split[i].equals(",")) {
                    if (split[i].equals("}")) break;
                    tmp.append(split[i]);
                    i++;
                }
                if (tmp.length() == 0) break;
                Integer key = Integer.parseInt(tmp.toString());
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
                i++;
            } while (!split[i].equals("}"));
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] n = new Solution64065().solution("{{20,111},{111}}");
        System.out.println(Arrays.toString(n));
    }
}
