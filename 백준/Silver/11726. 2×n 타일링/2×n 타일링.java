import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(4, n + 1)];
        dp[1] = 1;
        dp[2] = 2;
        int i = 3;
        while (n >= i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            i++;
        }
        System.out.println(dp[n] % 10007);
    }
}
