class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        for(int num : nums) 
            numSet.add(num);

        int maxLength = 0;

        for(int num : nums) {
            if(!numSet.contains(num - 1)) {
                int length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
        
    }
}
