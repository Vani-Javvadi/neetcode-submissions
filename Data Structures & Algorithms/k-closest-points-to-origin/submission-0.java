class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // we have to build k  max heap , we will store index and distance 
        int n = points.length;
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));

        for(int i=0; i<n; i++) {
            double distance = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
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

    }  
}
