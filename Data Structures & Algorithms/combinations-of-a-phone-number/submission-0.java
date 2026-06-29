class Solution {
    List<String> letterComb = new ArrayList();
    HashMap<Character, List<Character>> digitToCharMap = new HashMap();
    
    public List<String> letterCombinations(String digits) {
        digitToCharMap.put('2', List.of('a', 'b', 'c'));
        digitToCharMap.put('3', List.of('d', 'e', 'f'));
        digitToCharMap.put('4', List.of('g', 'h', 'i'));
        digitToCharMap.put('5', List.of('j', 'k', 'l'));
        digitToCharMap.put('6', List.of('m', 'n', 'o'));
        digitToCharMap.put('7', List.of('p', 'q', 'r', 's'));
        digitToCharMap.put('8', List.of('t', 'u', 'v'));
        digitToCharMap.put('9', List.of('w', 'x', 'y', 'z'));
        
        letterCombinations(0, digits, "");
        return letterComb;
    }

    public void letterCombinations(int index, String digits, String currComb) {
        if (index == digits.length()) {
            if (!currComb.isBlank())
                letterComb.add(new String(currComb));
            return;
        }
        for (char currChar : digitToCharMap.get(digits.charAt(index))) {
            letterCombinations(index+1, digits, currComb + currChar);
        }
    }
}
