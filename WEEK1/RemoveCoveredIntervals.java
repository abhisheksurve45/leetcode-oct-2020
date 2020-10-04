public class RemoveCoveredIntervals {

    class Solution {

        public int removeCoveredIntervals(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] currInt = {-1, -1};
            int overlap = 0;

            for (int[] interval : intervals) {

                if (currInt[0] <= interval[0] && currInt[1] >= interval[1]) {
                    overlap++;
                } else {

                    if (currInt[0] >= interval[0] && currInt[1] <= interval[1])
                        overlap++;

                    currInt = interval;
                }

            }

            return intervals.length - overlap;
        }
    }
}
