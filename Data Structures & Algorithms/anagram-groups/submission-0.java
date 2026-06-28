class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> keyVsAnagramMap = new HashMap<>();
        List<List<String>> result = new ArrayList();

        for (int i = 0; i < strs.length; i++) {
            char[] charecters = strs[i].toCharArray();
            Arrays.sort(charecters);
            String key = new String(charecters);

            keyVsAnagramMap.putIfAbsent(key, new ArrayList());
            keyVsAnagramMap.get(key).add(strs[i]);
        }

        for (List<String> val : keyVsAnagramMap.values()) {
            result.add(val);
        }

        return result;
    }
}
