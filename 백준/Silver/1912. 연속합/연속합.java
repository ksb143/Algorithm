import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = seq[0];
        int maxVal = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(seq[i], dp[i - 1] + seq[i]);
            maxVal = Math.max(dp[i], maxVal);
        }
        System.out.println(maxVal);
    }
}
