class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;

        Set<Integer> calculatedSum = new HashSet();
        calculatedSum.add(0);

        int target = sum / 2;
        for (int i  = 0; i < nums.length; i++) {
            Set<Integer> tempSet = new HashSet(calculatedSum);
            for(int j : tempSet) {
                if (j + nums[i] == target) 
                    return true;
                calculatedSum.add(j + nums[i]);
            }
        }
        return false;
    }
}
