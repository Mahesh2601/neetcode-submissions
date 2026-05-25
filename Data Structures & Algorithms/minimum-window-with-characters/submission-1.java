class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length(), tl = t.length();
        if (sl < tl) return "";
        int[] freq1 = new int[58], freq2 = new int[58];
        for (int i = 0; i < tl; i++) {
            freq1[s.charAt(i)-'A']++;
            freq2[t.charAt(i)-'A']++;
        }
        int start = 0, end = tl, resl = Integer.MAX_VALUE, ress = start, rese = end;
        while (end < sl) {
            while (containsAllThings(freq1, freq2)) {
                if (resl > (end-start+1)) {
                    resl = end-start+1;
                    ress = start; 
                    rese = end;
                }
                freq1[s.charAt(start)-'A']--;
                start++;
            }
            freq1[s.charAt(end)-'A']++;
            end++;
        }

        while (containsAllThings(freq1, freq2)) {
            if (resl > (end-start+1)) {
                resl = end-start+1;
                ress = start; 
                rese = end;
            }
            freq1[s.charAt(start)-'A']--;
            start++;
        }
        if (resl != Integer.MAX_VALUE) {
            return s.substring(ress, rese);
        }
        return "";
    }

    public boolean containsAllThings(int[] freq1, int[] freq2) {
        for (int i = 0; i < 58; i++) {
            if (freq1[i] < freq2[i]) return false;
        }
        return true;
    }

}
