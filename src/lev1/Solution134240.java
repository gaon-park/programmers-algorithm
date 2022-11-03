package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class Solution134240 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            sb.append(Integer.toString(i).repeat(food[i] / 2));
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new Solution134240().solution(new int[]{1, 3, 4, 6});
        System.out.println(s);
    }
}
