class Solution {
    private List<List<String>> partitions = new ArrayList();
    public List<List<String>> partition(String s) {
        getPartitions(0, s, new ArrayList());
        return partitions;
    }

    private void getPartitions(int index, String s, List<String> partition) {
        if (index >= s.length()) {
            partitions.add(new ArrayList(partition));
            return;
        }
        for (int j = index; j < s.length(); j++) {
            if (isPalindrome(s, index, j)) {
                partition.add(s.substring(index, j+1));
                getPartitions(j+1, s, partition);
                partition.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int last) {
        while(start < last) {
            if (s.charAt(start) != s.charAt(last))
                return false;
            start++;
            last--;
        }
        return true;
    }
}
