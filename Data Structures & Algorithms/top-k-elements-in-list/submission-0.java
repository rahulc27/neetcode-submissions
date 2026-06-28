class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        ArrayList<List<Integer>> frequency = new ArrayList(nums.length + 1);

        for (int i = 0; i <= nums.length; i++)
            frequency.add(new ArrayList());

        for (int num : nums) 
            count.put(num, 1 + count.getOrDefault(num, 0));

        for (Map.Entry<Integer, Integer> entry : count.entrySet())
            frequency.get(entry.getValue()).add(entry.getKey());

        int[] res = new int[k];
        int index = 0;

        for (int i = frequency.size() - 1; i > 0; i--) {
            for (int num : frequency.get(i)) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
        
    }
}
