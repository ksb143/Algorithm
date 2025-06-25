import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] shuttles = new int[n];
        shuttles[0] = 540;  // 첫 시간
        for (int i = 1; i < n; i++) {
            shuttles[i] = shuttles[i - 1] + t;
        }
        int[] intTimetable = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            int hour = Integer.parseInt(timetable[i].substring(0, 2)) * 60;
            int minute = Integer.parseInt(timetable[i].substring(3, 5));
            intTimetable[i] = hour + minute;
        }
        int[][] passengersNum = new int[n][];
        Arrays.sort(intTimetable);  // 정렬
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = idx; j < intTimetable.length; j++) {
                // 해당 셔틀 시간보다 빨리오거나 같은 시간 내에 오면
                if (shuttles[i] >= intTimetable[j]) {
                    list.add(intTimetable[j]);
                    cnt++;
                } else {
                    idx = j;
                    break;
                }
                if (cnt == m) {
                    idx = j + 1;
                    break;
                }
            }
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
            passengersNum[i] = arr;
        }

        int lastLen = passengersNum[n - 1].length;
        String answer = "";
        
        int hour, minutes;

        if (lastLen < m) {
            hour = shuttles[n - 1] / 60;
            minutes = shuttles[n - 1] % 60;
        } else {
            int pre = passengersNum[n - 1][m - 1] - 1;;
            hour = pre / 60;
            minutes = pre % 60;
        }
        String strHour = String.format("%02d", hour);
        String strMin = String.format("%02d", minutes);
        answer = strHour + ":" + strMin;
        return answer;
    }
}