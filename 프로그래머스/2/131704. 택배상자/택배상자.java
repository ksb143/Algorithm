import java.util.*;

class Solution {
    static int cnt = 0;
    static int idx = 0;

    private static void loadBox (Stack<Integer> stack) {
        stack.pop();
        cnt++;
        idx++;
    }

    private static void moveBox (Stack<Integer> main, Stack<Integer> second) {
        second.push(main.pop());
    }

    public static int solution(int[] order) {
        int n = order.length;  // 택배 수
        Stack<Integer> mainBelt = new Stack<>();  // 메인 컨베이어 벨트
        Stack<Integer> secondBelt = new Stack<>();  // 보조 컨베이어 벨트

        for (int i = n; i >= 1; i--) {
            mainBelt.push(i);
        }

        while (!mainBelt.isEmpty() || !secondBelt.isEmpty()) {
            if (!mainBelt.isEmpty()) {  // 메인 벨트가 비지 않았을 경우
                int currBoxNum = mainBelt.peek();
                if (currBoxNum == order[idx]) {  // 메인 벨트에 있는 박스가 순서에 맞는다면 싣기
                    loadBox(mainBelt);  // 버스에 싣기
                } else {  // 순서에 맞지 않는다면
                    if (!secondBelt.isEmpty()) {  // 보조 벨트가 비지 않았을 경우
                        int currSecBoxNum = secondBelt.peek();
                        if (currSecBoxNum == order[idx]) {  // 보조 벨트에 있는 제일 위의 박스가 순서에 맞는다면 싣기
                            loadBox(secondBelt);   // 버스에 싣기
                        } else {  // 순서에 맞지 않는다면
                            moveBox(mainBelt, secondBelt);  // 메인 벨트에 있는걸 보조 벨트에 옮기기
                        }
                    } else {  // 보조 벨트가 비어있는 경우
                        moveBox(mainBelt, secondBelt);  // 메인 벨트에 있는걸 보조 벨트에 옮기기
                    }
                }
            } else {  // 메인 벨트가 비어있는 경우
                if (!secondBelt.isEmpty()) {  // 보조 벨트가 비지 않았을 경우
                    int currSecBoxNum = secondBelt.peek();
                    if (currSecBoxNum == order[idx]) {  // 보조 벨트에 있는 제일 위의 박스가 순서에 맞는다면 싣기
                        loadBox(secondBelt);   // 버스에 싣기
                    } else {
                        break;
                    }
                } else {  // 보조 벨트도 비어있는 경우
                    break;
                }
            }
        }

        return cnt;
    }
}