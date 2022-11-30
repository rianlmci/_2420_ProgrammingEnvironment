/******************************************************************************
 *  Compilation:  javac Maze.java
 *  Execution:    java Maze.java cols rows
 *  Dependencies: StdDraw.java
 *
 *  Generates a perfect rows-by-rows maze using depth-first search with a stack.
 *
 *  % java Maze 16 16
 *
 *  % java Maze 32 18
 *
 *  Note: this program generalizes nicely to finding a random tree
 *        in a graph.
 *
 ******************************************************************************/
package graphMaze;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Maze {
    private final int cols, rows;   // dimension of maze
    private boolean[][] north;      // is there a wall to north of cell (col, row)
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean isDone = false;

    public Maze(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        int height = 800;
        int width = (int) Math.round(1.0 * height * cols / rows);
        StdDraw.setCanvasSize(width, height);

        StdDraw.setXscale(0, cols + 2);
        StdDraw.setYscale(0, rows + 2);
        init();
        generate();
    }

    private void init() {
        // initialize border cells as already visited
        visited = new boolean[cols + 2][rows + 2];
        for (int col = 0; col < cols + 2; col++) {
            visited[col][0] = true;
            visited[col][rows + 1] = true;
        }
        for (int row = 0; row < rows + 2; row++) {
            visited[0][row] = true;
            visited[cols + 1][row] = true;
        }


        // initialize all walls as present
        north = new boolean[cols + 2][rows + 2];
        east = new boolean[cols + 2][rows + 2];
        south = new boolean[cols + 2][rows + 2];
        west = new boolean[cols + 2][rows + 2];
        for (int col = 0; col < cols + 2; col++) {
            for (int row = 0; row < rows + 2; row++) {
                north[col][row] = true;
                east[col][row] = true;
                south[col][row] = true;
                west[col][row] = true;
            }
        }
    }


    // generate the maze
    private void generate(int col, int row) {
        visited[col][row] = true;

        // while there is an unvisited neighbor
        while (!visited[col][row + 1] || !visited[col + 1][row]
                || !visited[col][row - 1] || !visited[col - 1][row]) {

            // pick random neighbor (could use Knuth's trick instead)
            while (true) {
                double r = StdRandom.uniform(4);
                if (r == 0 && !visited[col][row + 1]) {
                    north[col][row] = false;
                    south[col][row + 1] = false;
                    generate(col, row + 1);
                    break;
                }
                else if (r == 1 && !visited[col + 1][row]) {
                    east[col][row] = false;
                    west[col + 1][row] = false;
                    generate(col + 1, row);
                    break;
                }
                else if (r == 2 && !visited[col][row - 1]) {
                    south[col][row] = false;
                    north[col][row - 1] = false;
                    generate(col, row - 1);
                    break;
                }
                else if (r == 3 && !visited[col - 1][row]) {
                    west[col][row] = false;
                    east[col - 1][row] = false;
                    generate(col - 1, row);
                    break;
                }
            }
        }
    }

    // generate the maze starting from lower left
    private void generate() {
        generate(1, 1);

/*
        // delete some random walls
        for (int i = 0; i < rows; i++) {
            int col = 1 + StdRandom.uniformInt(cols - 1);
            int row = 1 + StdRandom.uniformInt(rows - 1);
            north[col][row] = false;
            south[col][row + 1] = false;
        }

        // add some random walls
        for (int i = 0; i < cols; i++) {
            int col = cols / 2 + StdRandom.uniformInt(cols / 2);
            int row = rows / 2 + StdRandom.uniformInt(rows / 2);
            east[col][row] = west[col + 1][row] = true;
        }
*/
    }


    // solve the maze using depth-first search
    private void solve(int col, int row) {
        if (isDone) return;
        if (col == 0 || row == 0 || col == cols + 1 || row == rows + 1) return;
        if (visited[col][row]) return;
        visited[col][row] = true;

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(col + 0.5, row + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(250);

        // reached middle
        if (col == cols / 2 && row == rows / 2) isDone = true;

        if (!north[col][row]) solve(col, row + 1);
        if (!east[col][row]) solve(col + 1, row);
        if (!south[col][row]) solve(col, row - 1);
        if (!west[col][row]) solve(col - 1, row);

        if (isDone) return;

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(col + 0.5, row + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(250);
    }

    // solve the maze starting from the start state
    public void solve() {
        for (int col = 1; col <= cols; col++)
            for (int row = 1; row <= rows; row++)
                visited[col][row] = false;
        isDone = false;
        solve(1, 1);
    }

    // draw the maze
    public void draw() {
        int targetCol = cols / 2;
        int targetRow = rows / 2;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(targetCol + 0.5, targetRow + 0.5, 0.375);
        StdDraw.filledCircle(1.5, 1.5, 0.375);

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int col = 1; col <= cols; col++) {
            for (int row = 1; row <= rows; row++) {
                if (south[col][row]) StdDraw.line(col, row, col + 1, row);
                if (north[col][row]) StdDraw.line(col, row + 1, col + 1, row + 1);
                if (west[col][row]) StdDraw.line(col, row, col, row + 1);
                if (east[col][row]) StdDraw.line(col + 1, row, col + 1, row + 1);
            }
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }


    // a test client
    public static void main(String[] args) {
        int cols =  10; //Integer.parseInt(args[0]);
        int rows = 12; //Integer.parseInt(args[1]);
        Maze maze = new Maze(cols, rows);
        StdDraw.enableDoubleBuffering();
        maze.draw();
        maze.solve();
    }

}
