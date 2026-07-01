class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    // the intution is we will maintain min heap of size k always 
    // so when we have k elements in heap say 5,6,7 the kth largest among them will be min one which is want we have to return the kth largest one 
    // so we will construct a min of heap of size k , to return kth largest we will just return the peek element in min heap 

    // during intialization of min heap 
    // if we constructing a min heap with n elements, when we cross k elements , we have to remove one as we have to main min heap of size k 

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
    
    // while adding if min heap size is > K , we will add the current value , remove the peek to main min heap of size k 
    // return the peek
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    // TC - 
}
