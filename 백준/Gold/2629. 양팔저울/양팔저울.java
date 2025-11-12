import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static boolean isMeasurable(int[] suffixSum, boolean[][] seen, boolean[][] memo, int[] weights, int bead, int idx, int w) {
        if (w == bead) {
            return true;
        }

        if (Math.abs(bead - w) > suffixSum[idx]) {
            return false;
        }

        if (idx == N) {
            return false;
        }

        if (seen[idx][w]) {
            return memo[idx][w];
        }

        seen[idx][w] = true;

        boolean ans = (isMeasurable(suffixSum, seen, memo, weights, bead, idx + 1, Math.abs(w - weights[idx])) ||
                        isMeasurable(suffixSum, seen, memo, weights, bead, idx + 1, w + weights[idx]) ||
                        isMeasurable(suffixSum, seen, memo, weights, bead, idx + 1, w));

        memo[idx][w] = ans;
        return ans;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());  // 추 개수
        int[] weights = new int[N];
        int sumWeight = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sumWeight += weights[i];
        }
        int[] suffixSum = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + weights[i];
        }
        int M = Integer.parseInt(br.readLine());  // 구슬 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int bead = Integer.parseInt(st.nextToken());
            if (bead > sumWeight) {
                System.out.print("N ");
                continue;
            }
            boolean[][] seen = new boolean[N + 1][sumWeight + 1];
            boolean[][] memo = new boolean[N + 1][sumWeight + 1];
            if (isMeasurable(suffixSum, seen, memo, weights, bead, 0, 0)) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}
