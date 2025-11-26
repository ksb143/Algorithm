import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });
        for (int i = 0; i < N; i++) {
            long x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    long[] temps = pq.poll();
                    System.out.println(temps[1]);
                }
            } else {
                pq.add(new long[]{Math.abs(x), x});
            }
        }
    }
}
