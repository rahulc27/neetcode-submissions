class Solution {
    public int maxProduct(int[] nums) {
        //int res = Arrays.stream(nums).max().getAsInt();
        int res = nums[0];
        int currMax = 1, currMin = 1;

        for(int num : nums) {
            int tempMaxProduct = num * currMax;
            int tempMinProduct = num * currMin;
            currMax = Math.max(num, Math.max(tempMaxProduct, tempMinProduct));
            currMin = Math.min(num, Math.min(tempMaxProduct, tempMinProduct));
            res = Math.max(res, currMax);
        }

        return res;
    }
}
