class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSum(0, nums, new ArrayList(), 0, target);
        return res;
    }

    private void combinationSum(int index, 
                                int[] nums, 
                                List<Integer> currComb, 
                                int currSum,
                                int target) {

        if (currSum == target) {
            res.add(new ArrayList(currComb));
            return;
        }                

        if (currSum > target || index >= nums.length)
            return;
        
        currComb.add(nums[index]);
        combinationSum(index, nums, currComb, currSum + nums[index], target);

        currComb.removeLast();
        combinationSum(index+1, nums, currComb, currSum, target);
    }


}
