import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int result = bfs(n, adj);
        System.out.println(result);

    }
    public static int bfs(int n, ArrayList<ArrayList<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int cnt = 0;

        q.offer(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curNode = cur[0];
            int distance = cur[1];

            if(distance == 1 || distance == 2){
                cnt++;
            }
            if(distance > 2) continue;

            for(int neighbor : adj.get(curNode)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, distance+1});
                }
            }
        }
        return cnt;
    }
}
