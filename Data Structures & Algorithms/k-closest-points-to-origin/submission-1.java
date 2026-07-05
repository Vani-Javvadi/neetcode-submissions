class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // we have to build k  max heap , we will store index and distance 
        int n = points.length;

        // I have submitted one sol with double type distance where I did sqrt for distance caluclation - sqrt(2^2 + 2^2)
        // but any how when comparing 2 sqrt value if we cancel sqrt on both sides , that is fine so we can calculate distance with out sqrt and compare 

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for(int i=0; i<n; i++) {
            Integer distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            pq.offer(new Pair<>(i, distance));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i=0; i<k; i++) {
            int index = pq.poll().getKey();
            result[i][0] = points[index][0];
            result[i][1] = points[index][1];
        }

        return result;

        // TC - O(N*logK) + O(k*logK) -
        // O(N*logK)  we are inserting each point in heap where heap size is k  
        // O(k*logK) - while polling to return k closet points 

        // SC - O(K) -  pq of size k 

    }  
}
