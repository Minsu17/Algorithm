class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;

        for (int i = 0; i < 4; i++) {
            int nh = h + dy[i];
            int nw = w + dx[i];

            if (nh >= 0 && nh < n && nw >= 0 && nw < n) {
                if (board[h][w].equals(board[nh][nw])) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
