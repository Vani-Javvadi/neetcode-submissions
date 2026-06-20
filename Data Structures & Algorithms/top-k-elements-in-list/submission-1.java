class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // BF - take each traverse entire arraya to check how many times it has occurred 
        // if frequency is >= k , add the element to result array 
        // TC - O(N^2), O(1)

        // optimal 
        // I will use map to track frequency , when an element frequency is == K then I will add that element into result list 
        // Tc - O(N)
        // SC - O(N)
        int n = nums.length;
        // int[] res = new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        // solution using stream 

        // int[] list = map.entrySet().stream()
        // .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
        // .limit(k)
        // .mapToInt(Map.Entry::getKey).toArray();
        // return list;

        // TC - O(N) + (MlogM - hash map sorting)
        // SC - O(N) 

        // Solution 2 - sort the array and find the element from the end of list 
        // solution 3 - Heap - grouping numbers based on their frequency and constructing Max heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b) -> (b.getValue().compareTo(a.getValue()))
        );
        for(Map.Entry<Integer, Integer>  mp: map.entrySet()) {
            pq.offer(mp); 
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++) {
            Map.Entry<Integer, Integer> mp = pq.poll();
            list.add(mp.getKey());
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
