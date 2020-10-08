public class TwoSumIII {

    public class TwoSum {

        private HashMap<Integer, Integer> elements = new HashMap<>();

        public void add(int number) {
            elements.put(number, elements.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (Integer i : elements.keySet()) {
                int target = value - i;
                if (elements.containsKey(target)) {
                    if (i == target && elements.get(target) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }

}
