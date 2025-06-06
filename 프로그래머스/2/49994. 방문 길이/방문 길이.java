import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;

        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;

            switch (dir) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'L': nx--; break;
                case 'R': nx++; break;
            }

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            visited.add(path1);
            visited.add(path2);

            x = nx;
            y = ny;
        }

        return visited.size() / 2;
    }
}
