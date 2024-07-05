import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 원본 배열 복사 및 정렬
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // 좌표 압축을 위한 해시맵 생성
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int value : sortedArr) {
            if (!map.containsKey(value)) {
                map.put(value, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(map.get(value)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}