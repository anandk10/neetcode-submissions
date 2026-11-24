class Solution {

    int ROWS, COLS;
    
    public int numIslands(char[][] grid) {
        // dfs on every cell coordinate
        // when dfs returns count 1

        ROWS = grid.length;
        COLS = grid[0].length;
        int islands = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Cell currentCell = new Cell(i,j);
                if (grid[i][j] == '1') {
                    islands += dfs(grid, i, j);
                   //&& !visited.contains(currentCell)) {
                    // islands += dfs(grid, currentCell);
                }   
            }
        }
        return islands;
    }

    public record Cell(int i, int j) {}
    Set<Cell> visited = new HashSet<>();

    private int dfs(char[][] grid, int i, int j) {
        // boundary checking
        if (i < 0 || i == ROWS ||
            j < 0 || j == COLS ||
            grid[i][j] == '0') {
                return 0;
            }
        
        grid[i][j] = '0'; // marks it visited
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;
    }


    private int dfs(char[][] grid, Cell cell) {
        // boundary checking
        // base case
        if(cell.i() < 0 || cell.i() == ROWS ||
             cell.j() < 0 || cell.j() == COLS ||
             grid[cell.i()][cell.j()] == '0' ||
             visited.contains(cell)) {
            return 0;
        }

        visited.add(cell);
        dfs(grid, new Cell(cell.i() + 1, cell.j()));
        dfs(grid, new Cell(cell.i() - 1, cell.j()));
        dfs(grid, new Cell(cell.i(), cell.j() + 1));
        dfs(grid, new Cell(cell.i(), cell.j() - 1));
        return 1;
    }
}
