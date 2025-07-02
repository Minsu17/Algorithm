import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N+1][N+1];

        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> turn = new ArrayDeque<>();
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turn.add(new int[]{X, C == 'L' ? 0 : 1});
        }

        ArrayDeque<int[]> snake = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];

        int x = 1;
        int y = 1;
        int dir = 0;
        int time = 0;

        snake.offerFirst(new int[]{x,y});
        visited[x][y] = true;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny]){
                break;
            }

            if(board[nx][ny] == 1){
                board[nx][ny] = 0;
            }else {
                int[] tail = snake.pollLast();
                visited[tail[0]][tail[1]] = false;
            }

            snake.offerFirst(new int[]{nx,ny});
            visited[nx][ny] = true;
            x = nx;
            y = ny;

            if(!turn.isEmpty() && time == turn.peek()[0]){
                int[] t = turn.poll();
                int turnDir = t[1];
                if(turnDir == 0){
                    dir = (dir + 3) % 4;
                }else{
                    dir = (dir + 1) % 4;
                }
            }
        }
        System.out.println(time);
    }
}
