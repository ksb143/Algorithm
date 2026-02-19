import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    Integer N = Integer.parseInt(br.readLine());  // 도시 개수
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int[] cityLen = new int[N - 1];  // 도시 사이 길이
	    for (int i = 0; i < N - 1; i++) {
	        cityLen[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int[] pricePerLiter = new int[N];  // 리터 당 가격
	    for (int i = 0; i < N - 1; i++) {
	        pricePerLiter[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int currMin = pricePerLiter[0];
	    int answer = 0;
	    
	    answer += currMin * cityLen[0];
	    
	    for (int i = 1; i < N - 1; i++) {
	        if (pricePerLiter[i] < currMin) {
	            currMin = pricePerLiter[i];
	        }
	        answer += currMin * cityLen[i];
	    }
	    
	    System.out.println(answer);
	    
	}
}