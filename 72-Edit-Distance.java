
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        // Base case: converting empty word1 to word2
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    int insert = dp[j - 1];
                    int delete = dp[j];
                    int replace = prev;

                    dp[j] = 1 + Math.min(
                        insert,
                        Math.min(delete, replace)
                    );
                }

                prev = temp;
            }
        }

        return dp[n];
    }
}
