import java.util.*;
import java.io.*;


public class Main {
    static class Member {
        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 온라인 저지 회원수
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Member member = new Member(age, name, i);
            members.add(member);
        }

        members.sort(Comparator
                .comparingInt((Member e) -> e.age)
                .thenComparingInt(e -> e.idx));

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }

    }
}
