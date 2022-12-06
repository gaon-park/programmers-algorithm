package lev2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/87390
public class Solution87390 {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right - left) + 1];

        int index = 0, row, col;
        long x = left;
        while (x <= right) {
            row = (int) (x / n) + 1;
            col = (int) (x % n);

            if (col < row) {
                arr[index++] = row;
            } else {
                arr[index++] = col + 1;
            }

            x++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new Solution87390().solution(3, 2, 5);
        System.out.println(Arrays.toString(arr));
    }
}
