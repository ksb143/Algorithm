import java.io.*;
import java.util.*;

public class Main {
    static class File {
        String fileName;
        boolean isFile;

        File(String fileName, boolean isFile) {
            this.fileName = fileName;
            this.isFile = isFile;
        }

    }

    private static int[] bfs(HashMap<String, List<File>> map, String folder) {
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(folder);
        while (!q.isEmpty()) {
            String cf = q.poll();
            if (!map.containsKey(cf)) {
                continue;
            }
            for (File f : map.get(cf)) {
                if (f.isFile) {  // 파일이면 증가
                    set.add(f.fileName);
                    cnt++;
                } else {  // 폴더면 큐에 추가
                    q.add(f.fileName);
                }
            }
        }
        return new int[]{set.size(), cnt};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, List<File>> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();  // 상위 폴더
            String F = st.nextToken();  // 폴더 혹은 파일 이름
            int C = Integer.parseInt(st.nextToken());  // 폴더면 1, 파일이면 0
            File cf;
            if (C == 1) {
                cf = new File(F, false);
            } else {
                cf = new File(F, true);
            }
            map.computeIfAbsent(P, k -> new ArrayList<>()).add(cf);
        }


        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());  // 쿼리 수
        for (int i = 0; i < Q; i++) {
            String[] query = br.readLine().split("/");
            int[] ans = bfs(map, query[query.length - 1]);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
