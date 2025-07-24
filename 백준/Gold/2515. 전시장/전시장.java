import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 그림 개수
        int S = Integer.parseInt(st.nextToken());  // 판매 가능 그림 정수 길이

        int[][] pictures = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pictures[i][0] = Integer.parseInt(st.nextToken());
            pictures[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pictures, Comparator.comparingInt(a -> a[0]));  // 길이 오름차순 정렬

        int[] dp = new int[N];
        int max = 0;
        int left = 0;


        for (int i = 0; i < N; i++) {
            // 현재 그림과 높이 차가 S 이상 날 때까지 왼쪽 확장
            while (pictures[i][0] - pictures[left][0] >= S) {
                max = Math.max(max, dp[left]);
                left++;
            }

            dp[i] = Math.max(dp[i], max + pictures[i][1]);
        }

        int ans = 0;
        for (int val : dp) {
            if (val > ans) {
                ans = val;
            }
        }

        System.out.println(ans);

    }
}
