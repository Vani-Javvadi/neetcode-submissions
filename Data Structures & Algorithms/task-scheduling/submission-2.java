class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        pq.addAll(map.entrySet());
        map.clear();
         // or below code  we can use 
        // for(Map.Entry mp: map.entrySet()) {
        //     pq.offer(mp);
        // }

        Map<Character, Integer> tempMap = null;
        int ans = 0; 
        while(pq.size() != 0) {
            int cnt  = 0;
            tempMap = new HashMap<>();
            while(pq.size() != 0 && (n+1) != cnt) {
                Map.Entry<Character, Integer> mp = pq.poll();
                if(mp.getValue() > 1) {
                    tempMap.put(mp.getKey(), mp.getValue()-1);
                }
                cnt++;
            }
            if(tempMap.size() == 0) {
                ans += cnt; 
            }
            else if(n+1 == cnt) {
                ans += (n+1);
            } else {
                ans += (cnt + (n+1-cnt));
            }
            pq.addAll(tempMap.entrySet());
        }

        return ans; 

        // TC - O(N)  + (K * log K ) + (N * logK)  = 
        // o(N) - to insert all elements into map 
        // O(K * logK) - to construct heap for K distinct tasks 
        // O(N * logK) - to perform cycles by removing from heap and putting in heap , as we have N elements including all frequencies and we perfom heap on K distinct 
        
        // SC - O(K) - Map - K distinct tasks  + O(K) - heap 
    }
}
