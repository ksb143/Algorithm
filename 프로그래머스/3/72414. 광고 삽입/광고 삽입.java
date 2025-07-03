class Solution {
    private static int strToInt(String strTime) {
        String[] strArrTime = strTime.split(":");
        int totalTime = Integer.parseInt(strArrTime[0]) * 3600
                + Integer.parseInt(strArrTime[1]) * 60
                + Integer.parseInt(strArrTime[2]) * 1;
        return totalTime;
    }
    private static String intToStr(int time) {
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = time % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int totalTime = strToInt(play_time);  // 전체 영상 총 시간
        int advTotalTime = strToInt(adv_time);  // 광고 총 시간
        long[] totalView = new long[totalTime + 2];
        for (String log : logs) {
            String[] time = log.split("-");
            int start = strToInt(time[0]);
            int end = strToInt(time[1]);
            totalView[start] += 1;
            totalView[end] -= 1;
        }

        for (int i = 1; i <= totalTime; i++) {
            totalView[i] += totalView[i - 1];  // 시청자 수 누적 (각 초마다 실제 시청자 수)
        }
        for (int i = 1; i <= totalTime; i++) {
            totalView[i] += totalView[i - 1];   // 누적 재생 시간 (0 ~ i초까지 전체 누적 재생시간)
        }

        long maxTime = totalView[advTotalTime - 1];
        int maxStart = 0;

        for (int i = advTotalTime; i <= totalTime; i++) {
            long curr = totalView[i] - totalView[i - advTotalTime];
            if (curr > maxTime) {
                maxTime = curr;
                maxStart = i - advTotalTime + 1;
            }
        }


        return intToStr(maxStart);
    }
}