class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i,j,grid);
                    maxArea = Math.max(maxArea, count);
                    count = 0;
                }
            }
        }

        return maxArea;
    }

    private void dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
            return;
        
        grid[x][y] = 0;
        count++;
        for(int i = 0; i < 4; i++)
            dfs(x+dx[i], y+dy[i], grid);
    }
}
