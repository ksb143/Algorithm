import java.util.*;
import java.io.*;

// 길이가 2N인 벨트가 N 길이의 컨베이어 벨트를 위 아래 감싸며 돌고 있음
// 로봇 올리는 위치에만 올릴 수 있음
// 로봇 올리거나 이동 시 칸 내구도 1 감소 (로봇 이동 위해 칸 내구도 1 이상 남아야 함)
// 내구도 0인 카의 개수가 K 이상이면 과정 종료
public class Main {
    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);  // 벨트 길이
        int K = Integer.parseInt(input[1]);  // 종료 조건
        String[] arr = br.readLine().split(" ");
        int[] durabilityArr = new int[2 * N];  // 벨트 내구도 배열
        for (int i = 0; i < 2 * N; i++) {
            durabilityArr[i] = Integer.parseInt(arr[i]);
        }
        boolean[] robots = new boolean[2 * N];  // 해당 위치에 로봇 존재 여부 배열
        int zero = 0;  // 내구도 0인 벨트 개수
        int step = 0;  // 진행 중인 단계
        // 내구도 0인 벨트 개수가 K개 이상이면 종료
        while (zero < K) {
            step++;
            rotateBelt(durabilityArr, robots, N);  // 컨베이어 벨트 돌리기
            moveRobots(durabilityArr, robots, N);  // 로봇 움직이기
            // 로봇 올리기
            if (durabilityArr[0] > 0) {
                robots[0] = true;
                durabilityArr[0]--;
            }
            // 내구성 체크
            int check = 0;
            for (int durability : durabilityArr) {
                if (durability == 0) {
                    check++;
                }
            }
            zero = check;
        }
    System.out.println(step);
    }
    private static void rotateBelt(int[] durabilityArr, boolean[] robots, int N) {
        int lastDurability = durabilityArr[2 * N - 1];
        // 매개변수 (복사 원본, 원본 소스 읽어올 위치, 복사할 소스, 복사할 소스 시작 위치, 복사할 길이
        System.arraycopy(durabilityArr, 0, durabilityArr, 1, 2 * N - 1);
        durabilityArr[0] = lastDurability;
        for (int i = N - 2; i >= 0; i--) {
            robots[i + 1] = robots[i];
        }
        robots[0] = false;
        robots[N - 1] = false;
    }

    private static void moveRobots(int[] durabilityArr, boolean[] robots, int N) {
        for (int i = N - 2; i >= 0; i--) {
            if (robots[i] && !robots[i + 1] && durabilityArr[i + 1] > 0) {
                robots[i] = false;
                robots[i + 1] = true;
                durabilityArr[i + 1]--;
            }
        }
        robots[N - 1] = false;
    }
}
