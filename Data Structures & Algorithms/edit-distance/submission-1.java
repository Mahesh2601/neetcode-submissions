class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return dpRec(m-1, n-1, word1, word2, dp);
    }

    public int dpRec(int i, int j, String word1, String word2, int[][] dp) {
        if (i == -1 && j == -1) return 0;
        if (i == -1) return j+1;
        else if (j == -1) return i+1;

        if (dp[i][j] != -1) return dp[i][j];
        
        if (word1.charAt(i) == word2.charAt(j)) {
            return dpRec(i-1, j-1, word1, word2, dp);
        }
        return dp[i][j] = 1 + Math.min(
            dpRec(i-1, j-1, word1, word2, dp),
            Math.min(
                dpRec(i-1, j, word1, word2, dp),
                dpRec(i, j-1, word1, word2, dp)
            )
        );
    }
}
