import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100][100];

        for(int i=0;i<10;i++){
            int t = Integer.parseInt(br.readLine());
            int max = 0;

            for(int j=0;j<100;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<100;k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0; j < 100; j++) {
                int rowSum = 0;
                int colSum = 0;
                for(int k = 0; k < 100; k++) {
                    rowSum += arr[j][k];
                    colSum += arr[k][j];
                }
                max = Math.max(max, rowSum);
                max = Math.max(max, colSum);
            }

            int diag1 = 0;
            for(int j = 0; j < 100; j++) {
                diag1 += arr[j][j];
            }
            max = Math.max(max, diag1);

            int diag2 = 0;
            for(int j = 0; j < 100; j++) {
                diag2 += arr[j][99-j];
            }
            max = Math.max(max, diag2);

            System.out.println("#" + t + " " + max);
        }


    }
}
