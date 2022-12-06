package lev2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class Solution92341 {
    public LocalTime convert(String s) {
        String[] ar = s.split(":");
        return LocalTime.of(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]));
    }

    public int getDurationMin(String in, String out) {
        LocalTime inTime = convert(in);
        LocalTime outTime = convert(out);
        int hours = (int) ChronoUnit.HOURS.between(inTime, outTime);
        int minutes = (int) ChronoUnit.MINUTES.between(inTime, outTime) % 60;
        return hours * 60 + minutes;
    }

    public int getFee(int duration, int basicTime, int basicFee, int perTime, int perFee) {
        if (duration <= basicTime) return basicFee;
        return basicFee + (int) Math.ceil((duration - basicTime) / (double) perTime) * perFee;
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, String> logs = new HashMap<>();
        Map<String, Integer> durations = new HashMap<>();
        for (String record : records) {
            String[] tmp = record.split(" ");
            String car = tmp[1];
            if (tmp[2].equals("IN")) {
                logs.put(car, tmp[0]);
            } else {
                if (durations.containsKey(car)) {
                    durations.put(car, durations.get(car) + getDurationMin(logs.get(car), tmp[0]));
                } else {
                    durations.put(car, getDurationMin(logs.get(car), tmp[0]));
                }
                logs.remove(car);
            }
        }

        for (String key : logs.keySet()) {
            if (durations.containsKey(key)) {
                durations.put(key, durations.get(key) + getDurationMin(logs.get(key), "23:59"));
            } else {
                durations.put(key, getDurationMin(logs.get(key), "23:59"));
            }
        }

        List<String> keys = new ArrayList<>(durations.keySet());
        keys.sort((Comparator.comparingInt(Integer::parseInt)));
        int[] result = new int[keys.size()];
        int index = 0;
        for (String key : keys) {
            result[index++] = getFee(durations.get(key), fees[0], fees[1], fees[2], fees[3]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] n = new Solution92341().solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

        System.out.println(Arrays.toString(n));
    }
}
