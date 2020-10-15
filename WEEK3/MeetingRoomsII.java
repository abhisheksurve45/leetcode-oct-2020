public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(intervals[0].end);
        for (int i = 1; i < intervals.length; ++i) {
            if (minHeap.peek() <= intervals[i].start) minHeap.poll();
            minHeap.add(intervals[i].end);
        }

        return minHeap.size();
    }
}
