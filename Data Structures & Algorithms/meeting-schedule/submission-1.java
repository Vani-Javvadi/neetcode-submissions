/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        int n = intervals.size();
        if(n == 0) {
            return true;
        }
        Interval current = intervals.get(0);
        for(int i=1; i<n; i++) {
            if(current.end > intervals.get(i).start) {
                // conflict 
                return false;
            } else {
                current = intervals.get(i);
            }
        }
        return true;

    }
}
