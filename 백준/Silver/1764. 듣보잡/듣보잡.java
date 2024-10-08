import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                ans.add(name);
            }
        }
        
        Collections.sort(ans);
        
        System.out.println(ans.size());
        
        for (String name : ans) {
            System.out.println(name);
        }
        
    }
}