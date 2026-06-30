class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length -1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;
        for (int i = start; i < end; i++) {
            int currRob = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = currRob;
        }
        return rob2;
    }
}
