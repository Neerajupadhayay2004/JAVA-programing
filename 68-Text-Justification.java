
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();

            // Greedily find words that fit in this line
            while (j < n &&
                   lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int wordCount = j - i;
            StringBuilder line = new StringBuilder();

            // Last line or single-word line: left justified
            if (j == n || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(' ');
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } 
            // Fully justified line
            else {
                int totalSpaces = maxWidth;

                for (int k = i; k < j; k++) {
                    totalSpaces -= words[k].length();
                }

                int gaps = wordCount - 1;
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spaces = spacesPerGap;

                        // Extra spaces go to leftmost gaps
                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(' ');
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
