import java.util.*;

public class Solution {
    private List<String> answer = new ArrayList<>();
    private boolean[] visited;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        visited = new boolean[n];
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        dfs("ICN", "ICN", tickets, 0);
        return answer.get(0).split(" ");
    }

    private void dfs(String current, String path, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            answer.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}
