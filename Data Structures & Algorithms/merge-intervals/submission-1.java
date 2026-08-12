class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // sort the intervals 
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        // add the first interval to the result 
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=1; i<n; i++) {
            int[] prevInterval = st.peek();
            if(intervals[i][0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);
            } else {
                st.push(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        int[][] res = st.stream().toArray(int[][]::new);
        return res;
    }
}
