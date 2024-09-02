import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] ans = new int[n];
        int s = 0;

        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }


        Arrays.sort(A);
        for(int i=0;i<A.length;i++){
            int tmp = 0;
            int max = 0;
            for(int j=0;j<B.length;j++){
                if(B[j]>max) {
                    max = B[j];
                    tmp = j;
                }
            }
            s += A[i] * max;
            B[tmp] = -1;
        }
        System.out.println(s);
    }
}
