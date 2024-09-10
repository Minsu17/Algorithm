import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, cnt;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0;i<R;i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                map[i][j] = arr[j];
            }
        }
        back(R-1, 0, 1);

        System.out.println(cnt);
    }

    static void back(int x, int y, int depth){

        if(x == 0 && y == C - 1 ){
            if(depth == K){
                cnt++;
            }
            return;
        }
        if(x >= 0 && x < R && y >= 0 && y < C && map[x][y] != 'T' && !visited[x][y]){
            visited[x][y] = true;
            back(x+1, y, depth+1);
            back(x-1, y, depth+1);
            back(x, y+1, depth+1);
            back(x, y-1, depth+1);
            visited[x][y] = false;
        }
    }
}
