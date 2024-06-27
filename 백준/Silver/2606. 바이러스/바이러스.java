import java.util.*;

public class Main{
	
	static boolean visited[];
	static int map[][];
	static int cnt = 0;
	
	static int node, line;
	
	static Queue<Integer> q = new LinkedList<>();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        node = sc.nextInt();
        line = sc.nextInt();
        
        map = new int[node+1][node+1];
        visited = new boolean[node+1];
        
        for(int i=0;i<line;i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	map[a][b] = 1;
        	map[b][a] = 1;
        }
        dfs(1);
        
        
        System.out.println(cnt-1);
        sc.close();
    }
    
    static void dfs(int start) {
    	visited[start] = true;
    	cnt++;
    	
    	for(int i=0;i<=node;i++) {
    		if(map[start][i] == 1 && !visited[i]) {
    			dfs(i);
    		}
    	}
    }
    
}