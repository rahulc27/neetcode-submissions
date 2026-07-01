class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int count = 0;
                if(i-1 >= 0) 
                    count += dp[i-1][j];
                
                if(j - coins[i] >= 0)
                    count += dp[i][j - coins[i]];
                dp[i][j] = count;
            }
        }

        return dp[coins.length-1][amount];
    }
}
