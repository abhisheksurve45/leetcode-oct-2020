public class CombinationSum {

    class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> sums = new ArrayList<>();
            combinationSumHelper(candidates, target, 0, new ArrayList<>(), sums);
            return sums;
        }

        public void combinationSumHelper(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> sums) {

            if (target < 0) {
                return;
            }

            if (target == 0) {
                sums.add(new ArrayList<>(curr));
                return;
            }

            for (int i = index; i < candidates.length; i++) {

                curr.add(candidates[i]);

                combinationSumHelper(candidates, target - candidates[i], i, curr, sums);

                curr.remove(curr.size() - 1);
            }
        }
    }

}
