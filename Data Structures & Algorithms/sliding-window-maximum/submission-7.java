class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // we have to use heap and DQ here 
        // we are using dequeue to remove the elements from rear and add the elements from front 

        // we will insert first into Dequeue and in max heap 

        // in heap we will store pair , pair<value, index> , so that when we are removing an element from DQ and if element is present in peek of maxheap we have to remove that also 

        int n = nums.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getKey(), a.getKey()));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++) {
            pq.add(new Pair<>(nums[i], i));
        }
        list.add(pq.peek().getKey());
        for(int i=k; i<n; i++) {
            // remove all the elements which deos not contribute to window 
            // ex - [9,10,9,-7,-4,-8,2,-6] k = 5 
            while(pq.size() != 0 && pq.peek().getValue() <= i-k) {
                pq.poll();
            }
            // if current element is greater than max heap value 
            // then we can remove the max heap , because for the next elements the current one will be maximum 
            if(pq.size() != 0 && pq.peek().getKey() < nums[i]) {
                pq.poll();
            }
            pq.offer(new Pair<>(nums[i], i));
            list.add(pq.peek().getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
