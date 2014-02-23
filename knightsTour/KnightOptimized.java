public class KnightOptimized extends Knight {

    public KnightOptimized(int n) {
        super(n);
    }

    public int countMoves(int x, int y) {
        if (x < 0 || y < 0 || x >= gridSize || y >= gridSize || grid[x][y] != 0) {
            return 694;
        }
        int moves = 0;
        if (x+1 < gridSize && y+2 < gridSize && grid[x+1][y+2] == 0) {
            moves ++;
        }
        if (x+2 < gridSize && y+1 < gridSize && grid[x+2][y+1] == 0) {
            moves ++;
        }
        if (x >= 1 && y >= 2 && grid[x-1][y-2] == 0) {
            moves ++;
        }
        if (x >= 2 && y >= 1 && grid[x-2][y-1] == 0) {
            moves ++;
        }
        if (x+1 < gridSize && y >= 2 && grid[x+1][y-2] == 0) {
            moves ++;
        }
        if (x >= 1 && y+2 < gridSize && grid[x-1][y+2] == 0) {
            moves ++;
        }
        if (x >= 2 && y+1 < gridSize && grid[x-2][y+1] == 0) {
            moves ++;
        }
        if (x+2 < gridSize && y >= 1 && grid[x+2][y-1] == 0) {
            moves ++;
        }
        return moves;
    }

    public int findBestMove(int x, int y) {
        int temp;
        int best = 1;
        int lowestCount = countMoves(x+1, y+2);
        if ((temp = countMoves(x+2, y+1)) < lowestCount) {
            best = 2;
            lowestCount = temp;
        }
        if ((temp = countMoves(x-1, y-2)) < lowestCount) {
            best = 3;
            lowestCount = temp;
        }
        if ((temp = countMoves(x-2, y-1)) < lowestCount) {
            best = 4;
            lowestCount = temp;
        }
        if ((temp = countMoves(x+1, y-2)) < lowestCount) {
            best = 5;
            lowestCount = temp;
        }
        if ((temp = countMoves(x-1, y+2)) < lowestCount) {
            best = 6;
            lowestCount = temp;
        }
        if ((temp = countMoves(x-2, y+1)) < lowestCount) {
            best = 7;
            lowestCount = temp;
        }
        if ((temp = countMoves(x+2, y-1)) < lowestCount) {
            best = 8;
            lowestCount = temp;
        }
        return best;
    }

    public void solve() {
        closed = false;
        super.solve();
    }

    public void solve(int x, int y, int n) {
        iter++;
        if (n == last) {
            solved = true;
        }
        else if (x >= 0 && y >= 0 && x < gridSize && y < gridSize) {
            grid[x][y] = n;
            //update(200);
            int bestPath = findBestMove(x, y);
            if (bestPath == 1) {
                solve(x+1, y+2, n+1);
            }
            else if (bestPath == 2) {
                solve(x+2, y+1, n+1);
            }
            else if (bestPath == 3) {
                solve(x-1, y-2, n+1);
            }
            else if (bestPath == 4) {
                solve(x-2, y-1, n+1);
            }
            else if (bestPath == 5) {
                solve(x+1, y-2, n+1);
            }
            else if (bestPath == 6) {
                solve(x-1, y+2, n+1);
            }
            else if (bestPath == 7) {
                solve(x-2, y+1, n+1);
            }
            else if (bestPath == 8) {
                solve(x+2, y-1, n+1);
            }
            if (!solved) {
                grid[x][y] = 0;
            }
            else {
                System.out.println("Step " + n + ": (" + x + ", " + y + ")");
            }
        }
    }
}
