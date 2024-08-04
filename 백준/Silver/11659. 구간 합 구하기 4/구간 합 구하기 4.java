import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i];
		}
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
			sb.append(sum[end] - sum[start - 1]).append("\n");
		}
        System.out.println(sb);
    }
}

//출력 예시
//sum[1] = 5
//sum[2] = 5 + 4 = 9
//sum[3] = 9 + 3 = 12
//sum[4] = 12 + 2 = 14
//sum[5] = 14 + 1 = 15

//ex) 2 4
//구간 합은 prefixSum[4] - prefixSum[2-1] = 14 - 5 = 9