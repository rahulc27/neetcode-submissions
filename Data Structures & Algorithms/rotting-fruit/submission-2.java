class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int orangesRotting(int[][] grid) {

        Queue<int[]> nodeQueue = new LinkedList();
        int freshOranges = 0;

        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    nodeQueue.add(new int[]{row,col});
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
                    
            }
        }

        int minutes = 0;

        while(!nodeQueue.isEmpty() && freshOranges > 0) {
            int currLevelSize = nodeQueue.size();

            for(int i = 0; i < currLevelSize; i++) {
                int[] currNode = nodeQueue.poll();
                for(int j = 0; j < 4; j++) {
                    int x = currNode[0] + dx[j];
                    int y = currNode[1] + dy[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = -1;
                        freshOranges--;
                        nodeQueue.add(new int[]{x,y});
                    }
                }
                
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
