
import java.util.*;
import java.io.*;

public class Main {
    static HashMap<String, String> parent;  // 조상
    static HashMap<String, Integer> size;  // 네트워크 사이즈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        for (int i = 0; i < tc; i++) {
            int F = Integer.parseInt(br.readLine());  // 친구 관계 수
            parent = new HashMap<>();
            size = new HashMap<>();
            for (int j = 0; j < F; j++) {
                String[] Ids = br.readLine().split(" ");  // 두 사용자의 아이디
                String one = Ids[0]; String two = Ids[1];
                if (!parent.containsKey(one)) {
                    parent.put(one, one);
                    size.put(one, 1);
                }
                if (!parent.containsKey(two)) {
                    parent.put(two, two);
                    size.put(two, 1);
                }
                union(one, two);

            }
        }
    }

    // 부모노드 찾기 (경로 압축)
    public static String find(String name) {
        if (!name.equals(parent.get(name))) {
            parent.put(name, find(parent.get(name)));
        }
        return parent.get(name);
    }
    // 합집합
    public static void union(String a, String b) {
        a = find(a);
        b = find(b);
        // 이미 같은 집합 아닐 때만 합치기
        if (!a.equals(b)) {
            // 사이즈가 더 큰 쪽이 부모
            if (size.get(a) < size.get(b)) {
                parent.put(a, b);
                size.put(b, size.get(a) + size.get(b));
                System.out.println(size.get(b));
            } else {
                parent.put(b, a);
                size.put(a, size.get(a) + size.get(b));
                System.out.println(size.get(a));
            }
        } else {
            System.out.println(size.get(a));
        }

    }

}
