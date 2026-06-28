class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(0, nums, new ArrayList());
        return res;
    }

    private void subsetsWithDup(int index, int[] nums, List<Integer> subset) {
        if (index >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[index]);
        subsetsWithDup(index+1, nums, subset);

        subset.removeLast();
        int currElement = nums[index];
        while(index< nums.length && currElement == nums[index])
            index++;
        subsetsWithDup(index, nums, subset);
    }
}
