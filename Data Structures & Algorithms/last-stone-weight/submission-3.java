class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int n = stones.length;
        // Put all the elements in Max heap 
        // then each time we will pick max 2 elements from heap 
        // check if they are not equal , the add different to heap
        // if equal don't add anything just remove them 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<n; i++) {
            pq.add(stones[i]);
        }

        while(pq.size() >= 2) {
            int l1 = pq.poll();
            int l2 = pq.poll();
            if(l1 != l2) {
                pq.offer(l1-l2);
            }
        } 
        if(pq.size() == 0) {
            return 0;
        } 
        return pq.peek();

        // TC - O(N*logN) construct max heap - log N for max heapify + O(n/2) * (logn) - everytime we remove 2 elements we have to heapify again 
        
        
    }
}
