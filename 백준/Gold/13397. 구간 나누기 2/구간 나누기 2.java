import java.util.*;
import java.io.*;

public class Main {
    private static boolean check(int arr[], int x, int N, int M) {
        int cnt = 1;  // 현재까지 만든 구간 개수
        int curMax = arr[0];  // 현재 구간의 최댓값
        int curMin = arr[0];  // 현재 구간의 최솟값

        for (int i = 1; i < N; i++) {
            curMax = Math.max(curMax, arr[i]);
            curMin = Math.min(curMin, arr[i]);

            if (curMax - curMin > x) {
                // 이 원소까지 포함 시 x를 넘으니 이전까지 한 구간으로 자르고 새 구간 시작
                cnt += 1;
                curMax = arr[i];
                curMin = arr[i];
            }
        }

        return (cnt <= M);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;  // 전체에서 가장 큰 값
        int min = 10000;  // 전체에서 가장 작은 값
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 이분 탐색
        int left = 0;
        int right = max - min;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(arr, mid, N, M)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);



    }
}
