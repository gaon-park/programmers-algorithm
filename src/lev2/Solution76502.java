package lev2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Solution76502 {
    public boolean check(ArrayDeque<String> s) {
        Stack<String> stack = new Stack<>();
        Map<String, String> compareMap = new HashMap<>();
        compareMap.put(")", "(");
        compareMap.put("}", "{");
        compareMap.put("]", "[");
        for (String tmp : s) {
            if (compareMap.containsValue(tmp)) {
                stack.add(tmp);
            } else if (compareMap.containsKey(tmp)) {
                if (stack.size() > 0 && stack.peek().equals(compareMap.get(tmp))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public int solution(String s) {
        ArrayDeque<String> que = new ArrayDeque<>(Arrays.asList(s.split("")));
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                que.addLast(Objects.requireNonNull(que.pollFirst()));
            }
            if (check(que)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = new Solution76502().solution("}]()[{");
        System.out.println(n);
    }
}
