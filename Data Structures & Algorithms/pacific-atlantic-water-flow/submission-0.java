class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int nRow = heights.length, nCol = heights[0].length;
        int[][] visitCount = new int[nRow][nCol];
        int[][] visitSet = new int[nRow][nCol];
        List<List<Integer>> res = new ArrayList();

        for(int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (i == nRow - 1 || j == nCol - 1) {
                    dfs(i,j,heights,visitCount, visitSet);
                }       
            }
        }

        visitSet = new int[nRow][nCol];
        for(int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (i == 0 || j == 0) {
                    dfs(i,j,heights, visitCount, visitSet);
                }      
            }
        }

        for(int i = 0; i < nRow; i++) {
            for(int j = 0; j < nCol; j++) {
                if (visitCount[i][j] > 1)
                    res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void dfs(int x, int y, int[][] heights, int[][] visitCount, int[][] visitSet) {
        if(visitSet[x][y] == 1) {
            return;
        }
        
        visitSet[x][y] = 1;
        visitCount[x][y]++;

        for(int i = 0; i < 4; i++){
            int nextX =  x + dx[i];
            int nextY = y + dy[i]; 
            if (nextX >= 0 && nextX < heights.length 
                && nextY >= 0 && nextY < heights[0].length 
                && heights[x][y] <= heights[nextX][nextY])
                dfs(nextX, nextY, heights, visitCount, visitSet);
        }
    }
}
