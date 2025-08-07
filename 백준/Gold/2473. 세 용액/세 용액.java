import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 전체 용액 수
        long[] liquids = new long[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(liquids);

        long minVal = Long.MAX_VALUE;
        long[] ans = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = liquids[i] + liquids[left] + liquids[right];
                if (Math.abs(sum) < minVal) {
                    minVal = Math.abs(sum);
                    ans[0] = liquids[i];
                    ans[1] = liquids[left];
                    ans[2] = liquids[right];
                }

                if (sum < 0) {
                    left++;  // 합이 작으니까 더 크게
                } else {
                    right--;  // 합이 크니까 더 줄이기
                }

            }
        }

        for (long x : ans) {
            System.out.print(x + " ");
        }

    }
}
