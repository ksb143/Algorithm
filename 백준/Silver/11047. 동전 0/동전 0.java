import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 가지고 있는 동전 종류
        int K = Integer.parseInt(st.nextToken());  // 만들려는 합
        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;  // 동전 최솟값
        for (int i = 0; i < N; i++) {
            count += K / coins[i];
            K = K % coins[i];
        }
        System.out.println(count);

    }
}
