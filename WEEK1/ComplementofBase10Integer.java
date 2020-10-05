public class ComplementofBase10Integer {

    class Solution {

        public int bitwiseComplement(int num) {
            int n = 1;
            while (n < num) {
                n = (n << 1) | 1;
            }
            return n - num;
        }
    }

}
