class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // DLQ of size K 
        // the frontend element will hold maximum value in window 
        // once we move out of the window , we will remove the front , if front is part of window 
        Deque<Integer> dlq = new ArrayDeque<>();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            // check if current element us gretarer than previus one then
            // that will be maximum for next consecutive elements in window 
            // so we can remove the current one 
            // example - 1,3,1,2
            while(!dlq.isEmpty() && nums[dlq.peekLast()] < nums[i]) {
                dlq.pollLast();
            }
            dlq.offerLast(i);
            // if front element no longer part of window remove 
            if(dlq.peekFirst() <= i-k) {
                dlq.pollFirst();
            }
            // add front element to list 
            if(i >= k-1) {
                list.add(nums[dlq.peekFirst()]);
            } 
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}
