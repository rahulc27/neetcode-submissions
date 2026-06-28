class Solution {
    private List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(0, candidates, new ArrayList(), 0, target);
        return res;
    }

    private void combinationSum(int index, 
                                int[] candidates, 
                                List<Integer> currComb, 
                                int currSum, 
                                int target) {
        
        if (currSum == target) {
            res.add(new ArrayList(currComb));
            return;
        }
        if (currSum > target || index >= candidates.length)
            return;
        
        currComb.add(candidates[index]);
        combinationSum(index+1, candidates, currComb, currSum + candidates[index], target);
        currComb.removeLast();
        int currElement = candidates[index];
        int currIndex = index + 1;
        while(index < candidates.length && candidates[index] == currElement)
            index++;

        combinationSum(index, candidates, currComb, currSum, target);

    }
}
