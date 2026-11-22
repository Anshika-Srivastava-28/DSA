import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {

        HashSet<String> set = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];

            StringBuilder newLocal = new StringBuilder();

            for (int i = 0; i < local.length(); i++) {

                char ch = local.charAt(i);

                if (ch == '+') {
                    break;
                }

                if (ch != '.') {
                    newLocal.append(ch);
                }
            }

            String newEmail = newLocal.toString() + "@" + domain;

            set.add(newEmail);
        }

        return set.size();
    }
}