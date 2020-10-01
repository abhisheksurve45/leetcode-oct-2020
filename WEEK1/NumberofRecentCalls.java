public class NumberofRecentCalls {

    class RecentCounter {

        private Queue<Integer> q;

        public RecentCounter() {
            this.q = new LinkedList<>();
        }

        public int ping(int t) {
            this.q.offer(t);

            while (!this.q.isEmpty() && this.q.peek() + 3000 < t) this.q.poll();

            return this.q.size();
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
}
