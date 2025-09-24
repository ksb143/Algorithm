import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);  // 정렬
        int idx = 0;
        int cost = 0;
        for (int j = N - 1; j >= 0; j--) {
            if (idx == 2) {
                idx = 0;
                continue;
            }
            idx++;
            cost += arr[j];
        }

        System.out.println(cost);

    }
}
