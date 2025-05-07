import java.util.*;
import java.io.*;

public class Main {
    private static int bfs(int num, List<List<Integer>> adjLst, boolean[] visited ) {
        visited[num] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adjLst.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] number = br.readLine().split(" ");
        int N = Integer.parseInt(number[0]);  // 정점 개수
        int M = Integer.parseInt(number[1]);  // 간선 개수
        List<List<Integer>> adjLst = new ArrayList<>();  // 연결 리스트
        // 연결 리스트 하나씩 만들기
        for (int i = 0; i <= N; i++) {
            List<Integer> lst = new ArrayList<>();
            adjLst.add(lst);
        }
        // 연결되어 있는것 표시
        for (int i = 0; i < M; i++) {
            String[] points = br.readLine().split(" ");
            int u = Integer.parseInt(points[0]);
            int v = Integer.parseInt(points[1]);
            adjLst.get(u).add(v);
            adjLst.get(v).add(u);
        }
        int count = 0;  // 연결 요소 개수
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            count += bfs(i, adjLst, visited);
        }
        System.out.println(count);

    }
}
