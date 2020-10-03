public class MaximumDistanceinArrays {

    /**
     * https://dilyar85.gitbooks.io/leetcode-solutions-with-analysis/content/Problems/624_maximum_distance_in_arrays_java.html
     */

    class Solution {

        public int maxDistance(List<List<Integer>> arrays) {

            if (arrays == null || arrays.size() < 2) {
                return 0;
            }

            int result = Integer.MIN_VALUE;

            int min = arrays.get(0).get(0);
            int max = arrays.get(0).get(arrays.get(0).size() - 1);

            for (int i = 1; i < arrays.size(); i++) {

                int currMin = arrays.get(i).get(0);
                int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

                int currDis = Math.max(Math.abs(min - currMax), Math.abs(max - currMin));

                result = Math.max(result, currDis);

                min = Math.min(min, currMin);
                max = Math.max(max, currMax);
            }

            return result;
        }
    }
}
