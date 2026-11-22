import java.util.*;

class Solution {

    public String frequencySort(String s) {

        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create Max Heap
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Step 3: Add characters into heap
        for (char ch : map.keySet()) {
            pq.offer(ch);
        }

        // Step 4: Build result
        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            char ch = pq.poll();

            int frequency = map.get(ch);

            for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}