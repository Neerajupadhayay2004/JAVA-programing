
class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0;          // String pointer
        int j = 0;          // Pattern pointer

        int star = -1;      // Last star position
        int match = 0;      // String position matched by star

        while (i < s.length()) {

            // Characters match or '?' matches any character
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {

                i++;
                j++;
            }

            // Store '*' position
            else if (j < p.length() && p.charAt(j) == '*') {

                star = j;
                match = i;
                j++;
            }

            // Retry by extending the previous '*'
            else if (star != -1) {

                j = star + 1;
                match++;
                i = match;
            }

            // No possible match
            else {
                return false;
            }
        }

        // Ignore remaining '*' characters
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
