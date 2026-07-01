class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] sum = new int[amount + 1];
        Arrays.fill(sum, Integer.MAX_VALUE);
        for(int coin : coins) {
            if (coin <= amount)
                sum[coin] = 1;
        }

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if (coin < i && sum[i - coin] != Integer.MAX_VALUE)
                    sum[i] = Math.min(sum[i], 1 + sum[i - coin]);
            }
        }
        
        return sum[amount] == Integer.MAX_VALUE ? -1 : sum[amount];
    }
}
