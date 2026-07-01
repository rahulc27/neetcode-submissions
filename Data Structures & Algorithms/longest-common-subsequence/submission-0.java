class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] grid = new int[m+1][n+1];
        for(int i = 0; i <= m; i++)
            Arrays.fill(grid[i], 0);

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j))
                    grid[i][j] = 1 + grid[i+1][j+1];
                else 
                    grid[i][j] = Math.max(grid[i+1][j], grid[i][j+1]);
            }
        }
        
        return grid[0][0];
    }
}
