class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int r = 0, c = 0;
        int n = grid.length;
        int m = grid[0].length;

        while(true) {
            char ch = grid[r][c];
            int nr = r, nc = c;

            if(ch == 'R') nc++;
            if(ch == 'L') nc--;
            if(ch == 'U') nr--;
            if(ch == 'D') nr++;

            if(nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == '*') {
                return new int[]{r, c};
            }

            grid[r][c] = '*';
            r = nr;
            c = nc;
        }
    }
}