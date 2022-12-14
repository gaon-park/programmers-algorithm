package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class Solution72412 {
    Map<String, List<Integer>> map;
    Map<Integer, List<List<Integer>>> combination;

    public void setResultComb(int[] visited) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                list.add(i);
            }
        }
        int key = list.size();
        List<List<Integer>> mainList = combination.getOrDefault(key, new ArrayList<>());
        mainList.add(list);
        combination.put(key, mainList);
    }

    public void setCombination(int[] visited, int start, int r) {
        if (r == 0) {
            setResultComb(visited);
        } else {
            for (int i = start; i < visited.length; i++) {
                visited[i] = 1;
                setCombination(visited, i + 1, r - 1);
                visited[i] = 0;
            }
        }
    }

    public void init(String[] info) {
        combination = new HashMap<>();
        for (int i = 0; i <= 4; i++) {
            setCombination(new int[4], 0, i);
        }

        map = new HashMap<>();
        for (String s : info) {
            String[] tmp = s.split(" ");
            for (int key : combination.keySet()) {
                if (combination.get(key).size() == 0) {
                    String mapKey = s.replaceAll(" ", "");
                    List<Integer> value = map.getOrDefault(mapKey, new ArrayList<>());
                    value.add(Integer.parseInt(tmp[4]));
                    map.put(mapKey, value);
                }
                for (List<Integer> list : combination.get(key)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 4; i++) {
                        if (list.contains(i)) {
                            sb.append("-");
                        } else {
                            sb.append(tmp[i]);
                        }
                    }
                    String mapKey = sb.toString();
                    List<Integer> value = map.getOrDefault(mapKey, new ArrayList<>());
                    value.add(Integer.parseInt(tmp[4]));
                    map.put(mapKey, value);
                }
            }
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
    }

    public int binarySearch(List<Integer> list, int target) {
        int begin = 0;
        int end = list.size();

        while (begin < end) {
            int mid = (begin + end) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

    public int[] solution(String[] info, String[] query) {
        init(info);
        int[] result = new int[query.length];
        int resultIndex = 0;
        for (String q : query) {
            String[] tmp = q.replaceAll(" and ", " ").split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.length - 1; i++) {
                sb.append(tmp[i]);
            }
            String key = sb.toString();
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int index = binarySearch(list, Integer.parseInt(tmp[4]));
            if (index < list.size()) {
                result[resultIndex++] = list.size() - index;
            } else {
                result[resultIndex++] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] n = new Solution72412().solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
        System.out.println(Arrays.toString(n));
    }
}
