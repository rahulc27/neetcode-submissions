class Solution {
    List<String> res = new ArrayList();
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res.add(s.substring(left, right+1));
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res.add(s.substring(left, right+1));
                left--;
                right++;
            }
        }
        return res.size();
    }
}
