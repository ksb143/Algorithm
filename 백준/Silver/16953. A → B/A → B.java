import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        Queue<long[]> q = new LinkedList<>();  // 큐
        q.offer(new long[] {A, 1});
        HashSet<Long> set = new HashSet<>();  // 중복 검사용
        set.add(A);
        long ans = -1;
        while (!q.isEmpty()) {
            long[] curr = q.poll();
            long n = curr[0];  // 현재 수
            long cnt = curr[1];  // 현재 카운트 개수
            // 2를 곱하기 연산
            long x1 = n * 2;
            if (!set.contains(x1) && x1 < B) {
                q.offer(new long[] {x1, cnt + 1});
                set.add(x1);
            } else if (x1 == B) {
                ans = cnt + 1;
                break;
            }
            // 1을 수의 가장 오른쪽에 추가하는 연산
            long x2 = n * 10 + 1;
            if (!set.contains(x2) && x2 < B) {
                q.offer(new long[] {x2, cnt + 1});
                set.add(x2);
            } else if (x2 == B) {
                ans = cnt + 1;
                break;
            }
        }

        System.out.println(ans);
    }
}
