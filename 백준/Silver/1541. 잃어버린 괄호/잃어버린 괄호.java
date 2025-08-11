import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> numLst = new ArrayList<>();
        ArrayList<Character> calLst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-') {
                calLst.add(c);  // 기호 넣기
                int num = Integer.parseInt(sb.toString());  // 숫자 변환
                numLst.add(num);  // 숫자 넣기
                sb = new StringBuilder();  // 초기화
            } else {
                sb.append(c);
            }
        }
        // 마지막 숫자 넣기
        int lastNum = Integer.parseInt(sb.toString());
        numLst.add(lastNum);

        int[] numArr = new int[numLst.size()];
        for (int i = 0; i < numLst.size(); i++) {
            numArr[i] = numLst.get(i);
        }

        // 덧셈 먼저 계산
        for (int i = 0; i < calLst.size(); i++) {
            char cal = calLst.get(i);
            if (cal == '+') {
                int num1 = numArr[i];
                int num2 = numArr[i + 1];
                numArr[i] = 0;
                numArr[i + 1] = num1 + num2;
            }
        }
        // 0 없애기
        ArrayList<Integer> restNumLst = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            if(numArr[i] != 0) {
                restNumLst.add(numArr[i]);
            }
        }
        int ans = restNumLst.get(0);  // 한개면 뺄셈이 없는 경우므로 바로 답 도출
        if (restNumLst.size() > 1) {  // 두 개 이상이면 뺄셈이 있는 경우므로 뺄셈 추가 계산
            for (int i = 1; i < restNumLst.size(); i++) {
                ans -= restNumLst.get(i);
            }
        }
        System.out.println(ans);
    }
}
