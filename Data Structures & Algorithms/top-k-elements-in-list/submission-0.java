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
        int[] res = new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int[] list = map.entrySet().stream()
        .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
        .limit(k)
        .mapToInt(Map.Entry::getKey).toArray();
        return list;
    }
}
