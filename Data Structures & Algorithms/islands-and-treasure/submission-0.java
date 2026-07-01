class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> nodeQueue = new LinkedList();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0) {
                    nodeQueue.add(new int[]{i,j});
                }
            }
        }

        int level = 0;
        while(!nodeQueue.isEmpty()) {
            int n = nodeQueue.size();

            for (int i = 0; i < n; i++) {
                int[] currNode = nodeQueue.poll();
                if (grid[currNode[0]][currNode[1]] == Integer.MAX_VALUE)
                    grid[currNode[0]][currNode[1]] = level;

                for (int j = 0; j < 4; j++) {
                    int x = currNode[0] + dx[j];
                    int y = currNode[1] + dy[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == Integer.MAX_VALUE) {
                        nodeQueue.add(new int[]{x,y});
                    }
                }
            }
            level++;
        }
    }
}
