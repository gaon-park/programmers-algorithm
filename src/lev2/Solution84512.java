package lev2;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class Solution84512 {
    public static String[] st = new String[]{"A", "E", "I", "O", "U"};
    public static String word;
    public static int idx;

    public int search(int index, int k, String s) {
        s += st[index];
        k--;
        idx++;
        if (word.equals(s)) {
            return idx;
        } else if (k > 0) {
            for (int i = 0; i < st.length; i++) {
                int tmp = search(i, k, s);
                if (tmp > 0) return tmp;
            }
        }
        return -1;
    }

    public int solution(String word) {
        Solution84512.word = word;
        Solution84512.idx = 0;
        int index = -1;
        for (int i = 0; i < st.length; i++) {
            index = search(i, 5, "");
            if (index > 0) break;
        }
        return index;
    }

    public static void main(String[] args) {
        int n = new Solution84512().solution("EIO");
        System.out.println(n);
    }
}
