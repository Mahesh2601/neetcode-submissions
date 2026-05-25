class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0, end = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while (end < n) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                while (set.contains(c)) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            set.add(c);
            end++;
            res = Math.max(res, end-start);
        }
        return res;
    }
}
