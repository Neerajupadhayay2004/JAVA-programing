
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            // Count frequency of each character
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // Create unique frequency-based key
            StringBuilder key = new StringBuilder();

            for (int num : count) {
                key.append('#').append(num);
            }

            // Group anagrams using the key
            map.computeIfAbsent(key.toString(),
                    k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
