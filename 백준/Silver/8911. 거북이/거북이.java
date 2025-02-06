import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();
            System.out.println(getMinRectangleArea(commands));
        }
    }

    private static int getMinRectangleArea(String commands) {
        int x = 0, y = 0;
        int dir = 0;
        
        int minX = 0, maxX = 0, minY = 0, maxY = 0;
        
        for (char command : commands.toCharArray()) {
            if (command == 'F') {
                x += dx[dir];
                y += dy[dir];
            } else if (command == 'B') {
                x -= dx[dir];
                y -= dy[dir];
            } else if (command == 'L') {
                dir = (dir + 3) % 4;
            } else if (command == 'R') {
                dir = (dir + 1) % 4;
            }
            
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
        
        return (maxX - minX) * (maxY - minY);
    }
}
