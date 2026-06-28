class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permute = new ArrayList();
        permute.add(new ArrayList());

        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> newPermute = new ArrayList();
            for(List<Integer> perm : permute) {
                for(int j = 0; j <= perm.size(); j++) {
                    List<Integer> permCopy = new ArrayList(perm);
                    permCopy.add(j, nums[i]);
                    newPermute.add(permCopy);
                }
            }
            permute = newPermute;
        }
        return permute;
    }
}
