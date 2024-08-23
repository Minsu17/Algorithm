import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        
        Arrays.fill(visited, false);
        
        for(int i=0;i<computers.length;i++){
            if(visited[i] == false){
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    static void dfs(int node, int[][] computers){
        visited[node] = true;
        
        for(int i=0;i<computers.length;i++){
            if(visited[i] == true || computers[node][i] != 1) continue;
            dfs(i, computers);
        }
    }
}