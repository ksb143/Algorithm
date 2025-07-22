import java.util.*;

class Solution {
    static int[][] ds = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // 방향
    static char[][] storages;
    static int N;
    static int M;
    // 지게차
    private static int forklift(char word) {
        int cnt = 0;
        List<int[]> lst = new ArrayList<>();
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 2][M + 2];
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : ds) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                
                if (nr < 0 || nr > N + 1 || nc < 0 || nc > M + 1) {  // 범위 밖
                    continue;
                }
                if (visited[nr][nc]) {  // 이미 방문
                    continue;
                }
                
                char c = storages[nr][nc];
                if (c == '.') {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                } else if (c == word) {
                    visited[nr][nc] = true;
                    lst.add(new int[]{nr, nc});
                    cnt++;
                }
            }
        }
        
        // 컨테이너 비우기
        for (int[] l : lst) {
            storages[l[0]][l[1]] = '.';
        }
        
        return cnt;
    }
    // 크레인
    private static int crane(char word) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (storages[i][j] == word) {
                    storages[i][j] = '.';  // 크레인으로 끌고가기
                    cnt++;  // cnt 높이기
                }
            }
        }
        return cnt;
    }
    public int solution(String[] storage, String[] requests) {
        N = storage.length;  // 세로
        M = storage[0].length();  // 가로
        // 주변에 둘러싸기
        storages = new char[N + 2][M + 2];
        for (int i = 0; i <= N + 1; i++) {
            for (int j = 0; j <= M + 1; j++) {
                if (i < 1 || i > N || j < 1 || j > M) {  // 둘러싼 곳은 '.'
                    storages[i][j] = '.';
                } else {  // 나머지는 컨테이너 그대로
                    storages[i][j] = storage[i - 1].charAt(j - 1);
                }
            }
        }

        int cnt = 0;

        for (String req : requests) {
            if (req.length() == 1) {  // 지게차
                cnt += forklift(req.charAt(0));
            } else {  // 크레인
                cnt += crane(req.charAt(0));
            }
        }
        
        
        return N * M - cnt;
    }
}