package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class Solution86971 {
    public Map<Integer, List<Integer>> map;

    public void init(int[][] wires) {
        map = new HashMap<>();
        for (int[] wire : wires) {
            List<Integer> list = map.getOrDefault(wire[0], new ArrayList<>());
            list.add(wire[1]);
            map.put(wire[0], list);

            list = map.getOrDefault(wire[1], new ArrayList<>());
            list.add(wire[0]);
            map.put(wire[1], list);
        }
    }

    public int search(int n, int size, int exceptI, int exceptJ) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(n);
        int[] visited = new int[size + 1];
        visited[0] = 1;
        visited[n] = 1;

        int count = 0;
        while (!que.isEmpty()) {
            int num = que.poll();
            count++;
            visited[num] = 1;

            for (int tmp : map.getOrDefault(num, new ArrayList<>())) {
                if (visited[tmp] == 0 && tmp != exceptI && tmp != exceptJ) {
                    que.add(tmp);
                }
            }
        }
        return count;
    }

    public int solution(int n, int[][] wires) {
        init(wires);

        int min = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int tmp1 = search(wire[0], n, wire[0], wire[1]);
            int tmp2 = search(wire[1], n, wire[0], wire[1]);

            min = Math.min(min, Math.abs(tmp1 - tmp2));
        }

        return min;
    }

    public static void main(String[] args) {
        int n = new Solution86971().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println(n);
    }
}
