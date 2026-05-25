class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return dpRec(text1.length()-1, text2.length()-1, text1, text2, dp);
    }

    public int dpRec(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + dpRec(i-1, j-1, text1, text2, dp);
        }
        return dp[i][j] = Math.max(
            dpRec(i-1, j, text1, text2, dp),
            dpRec(i, j-1, text1, text2, dp)
        );
    }
}
