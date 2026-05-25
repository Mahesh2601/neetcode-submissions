class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0, end = 0, n = s.length(), res = 0;
        while (end < n) {
            freq[s.charAt(end)-'A']++;
            while (!canOneDistinct(freq, k)) {
                freq[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(res, (end-start+1));
            end++;
        }
        return res;
    }

    public boolean canOneDistinct(int[] freq, int k) {
        int maxi = 0, total = 0;
        for (int i = 0; i < 26; i++) {
            maxi = Math.max(maxi, freq[i]);
            total += freq[i];
        }
        return (total-maxi) <= k;
    }
}
