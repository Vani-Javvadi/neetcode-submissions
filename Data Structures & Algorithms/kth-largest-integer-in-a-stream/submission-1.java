class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            pq.offer(nums[i]);
            if(i >= k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
