import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N + 1];  // 해당 작업 걸리는 시간
        int[][] preTasks = new int[N + 1][];  // 선행작업들
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());  // 걸리는 시간
            int M = Integer.parseInt(st.nextToken());  // 선행작업 수
            int[] preTask = new int[M];  // 선행작업
            for (int j = 0; j < M; j++) {
                preTask[j] = Integer.parseInt(st.nextToken());
            }
            preTasks[i] = preTask;
        }


        int[] endTimes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            endTimes[i] += times[i];
            int maxTime = 0;
            for (int idx : preTasks[i]) {
                if (endTimes[idx] > maxTime) {
                    maxTime = endTimes[idx];
                }
            }
            endTimes[i] += maxTime;
        }
        int ans = 0;
        for (int endTime : endTimes) {
            if (ans < endTime) {
                ans = endTime;
            }
        }

        System.out.println(ans);


    }
}
