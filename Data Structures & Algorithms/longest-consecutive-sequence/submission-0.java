class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> numberToSeqLength = new HashMap();
        int maxLength = 0;
        Arrays.sort(nums);

        for(int num : nums) {
            int currLength = 1 + numberToSeqLength.getOrDefault(num-1, 0);
            numberToSeqLength.put(num, currLength);
            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
        
    }
}
