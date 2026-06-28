class Solution {
    List<List<Integer>> subsets = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(0, nums, new ArrayList());
        return subsets;
    }

    public void subsets(int index, int[] nums, ArrayList<Integer> subset) {
        if (index >= nums.length) {
            subsets.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[index]);
        subsets(index+1, nums, subset);
        subset.removeLast();
        subsets(index+1, nums, subset);
    }
}
