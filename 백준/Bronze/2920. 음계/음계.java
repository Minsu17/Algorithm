import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[8];
        for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        Integer[] arrA = arr.clone();
        Integer[] arrD = arr.clone();
        
        Arrays.sort(arrA);
        Arrays.sort(arrD, Collections.reverseOrder());
        
        if(Arrays.equals(arr, arrA)) {
        	System.out.println("ascending");
        }
        else if(Arrays.equals(arr, arrD)){
        	System.out.println("descending");
        }
        else {
        	System.out.println("mixed");
        }
    }
}