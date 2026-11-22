class Solution {

    public char findTheDifference(String s, String t) {

        int[] count = new int[26];

        // Step 1: Count characters in s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        // Step 2: Subtract characters of t
        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);

            count[ch - 'a']--;

            // Step 3: Find the extra character
            if (count[ch - 'a'] < 0) {
                return ch;
            }
        }

        return ' ';
    }
}