class Solution {
    public int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();
        int currMax = 1, currMin = 1;

        for(int num : nums) {
            int temp = num * currMax;
            currMax = Math.max(num, Math.max(temp, num * currMin));
            currMin = Math.min(num, Math.min(temp, num * currMin));
            res = Math.max(res, currMax);
        }

        return res;
    }
}
