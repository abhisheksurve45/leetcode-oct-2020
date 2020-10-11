public class RemoveDuplicateLetters {

    class Solution {

        public String removeDuplicateLetters(String s) {

            int[] lastIndex = new int[26];

            for (int i = 0; i < s.length(); i++) {
                lastIndex[s.charAt(i) - 'a'] = i;
            }

            boolean[] seen = new boolean[26];
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                int index = s.charAt(i) - 'a';

                if (seen[index]) continue;

                while (!st.isEmpty() && st.peek() > index && i < lastIndex[st.peek()]) {
                    seen[st.pop()] = false;
                }

                seen[index] = true;
                st.push(index);

            }

            StringBuilder sb = new StringBuilder();

            while (!st.isEmpty()) {
                sb.append((char) (st.pop() + 'a'));
            }

            return sb.reverse().toString();
        }
    }
}
