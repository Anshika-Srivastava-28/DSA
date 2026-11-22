class Solution {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        // Case 1: Strings are already equal
        if (s.equals(goal)) {

            boolean[] seen = new boolean[26];

            for (char ch : s.toCharArray()) {

                if (seen[ch - 'a']) {
                    return true;
                }

                seen[ch - 'a'] = true;
            }

            return false;
        }

        // Case 2: Find mismatched positions
        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {

                if (first == -1) {
                    first = i;
                }
                else if (second == -1) {
                    second = i;
                }
                else {
                    return false;
                }
            }
        }

        // Check whether swapping these two positions works
        return second != -1 &&
               s.charAt(first) == goal.charAt(second) &&
               s.charAt(second) == goal.charAt(first);
    }
}