import java.util.*;
import java.io.*;

public class Main {
    static HashMap<String, Integer> nameToId;  // 이름 숫자로 변환
    static int[] parent;  // 부모 배열
    static int[] size;  // 네트워크 크기 배열
    static int idCounter;  // // 이름을 숫자로 변환할 때 사용하는 ID

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for (int i = 0; i < tc; i++) {
            int F = Integer.parseInt(br.readLine());  // 친구 관계 수
            nameToId = new HashMap<>();
            parent = new int[F * 2];
            size = new int[F * 2];
            idCounter = 0;
            // 초기화
            for (int j = 0; j < F * 2; j++) {
                parent[j] = j;
                size[j] = 1;
            }
            // 합집합 및 이름 숫자로 변경
            for (int j = 0; j < F; j++) {
                String[] ids = br.readLine().split(" ");  // 두 사용자의 아이디
                int one = getId(ids[0]);
                int two = getId(ids[1]);

                bw.write(union(one, two) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    // 이름 숫자로 변경
    public static int getId(String name) {
        if (!nameToId.containsKey(name)) {
            nameToId.put(name, idCounter);
            return idCounter++;
        }
        return nameToId.get(name);
    }
    // 부모노드 찾기 (경로 압축)
    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    // 합집합
    public static int union(int a, int b) {
        a = find(a);
        b = find(b);
        // 이미 같은 집합 아닐 때만 합치기
        if (a != b) {
            // 사이즈가 더 큰 쪽이 부모
            if (size[a] < size[b]) {
                parent[a] = b;
                size[b] += size[a];
                return size[b];
            } else {
                parent[b] = a;
                size[a] += size[b];
                return size[a];
            }
        } else {
            return size[a];
        }

    }

}
