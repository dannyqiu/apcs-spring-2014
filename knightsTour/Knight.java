public class Knight {

    protected int gridSize;
    protected int area;
    protected int last;
    protected int[][] grid;
    protected boolean solved;
    protected boolean closed = true;
    protected int iter;

    public Knight(int n) {
        changeSize(n);
    }

    public void changeSize(int n) {
        gridSize = n;
        area = n * n;
        last = area + 1;
        grid = new int[n][n];
    }

    public String clear() {
	return  "[2J";
    }

    public String go(int x, int y) {
	return ("[" + x + ";" + y + "H");
    }

    public String toString(){
        String str = "";
        for (int r=0; r<gridSize; r++) {
            for (int c=0; c<gridSize; c++) {
                str += expandString(grid[r][c], ("" + area).length());
            }
            str += "\n";
        }
        return str;
    }
    
    public String expandString(int n, int l) {
        String str = "" + n;
        int strL = str.length();
        for (int i=0; i<l-strL+1; i++) {
            str = " " + str;
        }
        return str;
    }


    public void wait(int millis) {
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void update(int millis) {
        wait(millis);
        System.out.print(clear() + go(0,0) + this);
    }

    public void solve() {
        solve(0, 0, 1);
        if (!solved) {
            if (closed) {
                System.out.println("There is no closed loop solution for a grid of size " + gridSize + "x" + gridSize + "!");
            }
            else {
                System.out.println("There is no solution for a grid of size " + gridSize + "x" + gridSize + "!");
            }
        }
        else {
            if (closed) {
                System.out.println("It took " + iter + " iterations to find a closed loop solution for a grid of size " + gridSize + "x" + gridSize + "!");
            }
            else {
                System.out.println("It took " + iter + " iterations to find an open loop solution for a grid of size " + gridSize + "x" + gridSize + "!");
            }
        }
    }

    public void solve(int x, int y, int n) {
        iter++;
        if (x >= 0 && y >= 0 && x < gridSize && y < gridSize) {
            //update(2);
            if (grid[x][y] == 0) {
                grid[x][y] = n;
                if (!solved) solve(x-2, y-1, n+1);
                if (!solved) solve(x-1, y+2, n+1);
                if (!solved) solve(x-2, y+1, n+1);
                if (!solved) solve(x+1, y+2, n+1);
                if (!solved) solve(x+2, y+1, n+1);
                if (!solved) solve(x-1, y-2, n+1);
                if (!solved) solve(x+2, y-1, n+1);
                if (!solved) solve(x+1, y-2, n+1);
                if (!solved) grid[x][y] = 0;
                if (solved) System.out.println("Step " + n + ": (" + x + ", " + y + ")");
            }
            else if (n == last) {
                if (!closed) {
                    solved = true;
                }
                else if (grid[x][y] == 1) {
                    solved = true;
                }
            }
        }
    }

    public void solveOpen() {
        closed = false;
        solve();
    }
    
}
