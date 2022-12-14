package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411
public class Solution72411 {
    public Map<String, Integer> map = new HashMap<>();

    public void setCombination(int[] visited, int start, int r, String[] arr, String s) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            String[] tmp = s.split("");
            Arrays.sort(tmp);
            for (String t : tmp) {
                sb.append(t);
            }
            String key = sb.toString();
            int value = map.getOrDefault(key, 0);
            map.put(key, value + 1);
        } else {
            for (int i = start; i < visited.length; i++) {
                visited[i] = 1;
                setCombination(visited, i + 1, r - 1, arr, s + arr[i]);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            for (int i = 2; i <= 10; i++) {
                setCombination(new int[order.length()], 0, i, order.split(""), "");
            }
        }

        List<String> list = new ArrayList<>();
        for (int num : course) {
            int max = 0;
            for (String key : map.keySet()) {
                if (key.length() == num && map.get(key) >= 2) {
                    max = Math.max(max, map.get(key));
                }
            }
            for (String key : map.keySet()) {
                if (key.length() == num && map.get(key) == max) {
                    list.add(key);
                }
            }
        }
        Collections.sort(list);
        return list.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] s = new Solution72411().solution(
                new String[]{"XYZ", "XWY", "WXA"},
                new int[]{2, 3, 4}
        );
        System.out.println(Arrays.toString(s));
    }
}
