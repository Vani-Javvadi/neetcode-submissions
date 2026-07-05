class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // we can do this solution in 2 way - one is by building a min heap by putting all points distance into it 
        // once we construct heap using distance , we will poll() the first k elements which are closest 

        // TC - O(N*logN) + O(k*logN) 
        // O(N*logN) - for heapify it will take logN as we are storing N points in heap 
        // O(K * logN) - to poll the top k elements from heap 
    

        // we have to build k  max heap , we will store index and distance 
        // the intution here is as we have to return k closest pints 
        // which are nothing but points at min distance , we will try to build a heap with k closest points 
        // when the heap size is > k , we will remove the elements with maximum distance so that heap will always have k min distance points 

        int n = points.length;

        // I have submitted one sol with double type distance where I did sqrt for distance caluclation - sqrt(2^2 + 2^2)
        // but any how when comparing 2 sqrt value if we cancel sqrt on both sides , that is fine so we can calculate distance with out sqrt and compare 
        // while revising check 2 solutions 
        
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
