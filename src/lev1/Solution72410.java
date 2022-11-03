package lev1;

// https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class Solution72410 {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase()
                .replaceAll("[^\\w\\-_.]*", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]", "")
                .replaceAll("[.]$", "");
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15)
                    .replaceAll("[.]$", "");
        }
        if (new_id.length() <= 2) {
            String s = new_id.split("")[new_id.length() - 1];
            while (new_id.length() <= 2) {
                new_id += s;
            }
        }
        return new_id;
    }

    public static void main(String[] args) {
        String s = new Solution72410().solution(	"abcdefghijklmn.p");
        System.out.println(s);
    }
}
