import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        int[] a = new int[n];
        int i = 0;
        while (i < n) {
            if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            else a[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        System.out.print(a[k]);
    }
}
