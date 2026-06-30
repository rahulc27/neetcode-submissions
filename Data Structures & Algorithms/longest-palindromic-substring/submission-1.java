class Solution {
    public String longestPalindrome(String s) {
        String res = new String();

        for (int i = 0; i < s.length(); i++) {
            res = checkPalindrome(i, i, s, res, res.length());
            res = checkPalindrome(i, i+1, s, res, res.length()); 
        }
        return res;
    }

    public String checkPalindrome(int left, int right, String s, String res, int resLen) {
        while(left >= 0 
                    && right < s.length() 
                    && s.charAt(left) == s.charAt(right)) {
                    
            if (resLen < right - left + 1) {
                res = s.substring(left, right + 1);
                resLen = res.length();
            }
            left--;
            right++;
        }
        return res;
    }
}
