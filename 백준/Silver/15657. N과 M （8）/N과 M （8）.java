import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    public static void dfs(int cnt, int[] nums, int[] ans) {
        if (cnt == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(ans[j] + " ");

            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (cnt > 0 && nums[i] < ans[cnt - 1]) {
                continue;
            }
            ans[cnt] = nums[i];
            dfs(cnt + 1, nums, ans);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];  // N개의 수열
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // N개 자연수 중 M개를 골라서 비내림차순인 것 (중복 뽑기 가능)
        Arrays.sort(nums);

        int[] ans = new int[M];
        dfs(0, nums, ans);

    }
}
