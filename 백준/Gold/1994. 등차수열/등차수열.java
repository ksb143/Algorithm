import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);  // 정렬

        List<Map<Integer, Integer>> dp = new ArrayList<>();  // 해당 공차 d로 끝나는 등차수열 길이

        for (int i = 0; i < N; i++) {
            dp.add(new HashMap<>());
        }

        int answer = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];  // 공차 계산
                int len = dp.get(j).getOrDefault(diff, 1) + 1;
                dp.get(i).put(diff, Math.max(dp.get(i).getOrDefault(diff, 1), len));
                answer = Math.max(answer, len);
            }
        }
        
        System.out.println(answer);

    }
}
