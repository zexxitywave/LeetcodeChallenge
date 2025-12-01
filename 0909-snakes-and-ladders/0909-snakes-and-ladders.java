class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // converts a cell number (1..n*n) to board coordinates
        // considering the zig-zag pattern
        int[] getPos = new int[2];

        // visited squares
        boolean[] visited = new boolean[n * n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int curr = q.poll();

                if (curr == n * n) return moves;

                // try dice rolls
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] pos = getCoordinates(next, n);
                    int r = pos[0], c = pos[1];

                    if (board[r][c] != -1) {
                        next = board[r][c];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    // convert square number -> (row, col)
    private int[] getCoordinates(int num, int n) {
        int r = n - 1 - (num - 1) / n;
        int c = (num - 1) % n;

        // reverse direction every other row
        if (((n - r) % 2) == 0) {
            c = n - 1 - c;
        }

        return new int[]{r, c};
    }
}
