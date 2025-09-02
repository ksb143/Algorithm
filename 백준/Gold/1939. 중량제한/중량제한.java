import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<int[]>> bridges;
    public static boolean canCarry(int x, int start, int end) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int cp = q.poll();
            for (int[] next : bridges.get(cp)) {
                int np = next[0];
                int nw = next[1];
                if (nw < x  || visited[np]) {  // 기준 맞지 않거나 이미 방문했을 때 넘기기
                    continue;
                }
                if (np == end) {  // 도착지 만나면 조기종료
                    return true;
                }
                q.offer(np);
                visited[np] = true;

            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 섬 개수
        M = Integer.parseInt(st.nextToken());  // 다리 개수
        bridges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            List<int[]> lst = new ArrayList<>();
            bridges.add(lst);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            bridges.get(A).add(new int[] {B, C});
            bridges.get(B).add(new int[] {A, C});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());  // 출발지
        int end = Integer.parseInt(st.nextToken());  // 목적지

        int ans = 0;
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canCarry(mid, start, end)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
