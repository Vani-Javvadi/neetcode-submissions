class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Followed Striver Explained approach 
        // Intutition =  we have to find current  partition among the 2 arrays so that all elements in left part 
        // are less than element from right part 
        // say if we have 6 elements in first array - 1 3 4 7 10 12 
        // And we have 4 elements in second array - 2 3 6 15 
        // the no.of possible partitions are in left side  [2,3] 2 elements from first array , 3 elemnts from second array 
        // when we do that we will get 2,3 and 1,3,4 as left partiton and remaining elements from 2 arrays will form right partition 
        // so we have to check if partition was correct or not by checking if all elements from left are less than all elements from right 
        // once we find the correct partition we can find median 

        int m = nums1.length, n = nums2.length;

        if(m > n) {
            findMedianSortedArrays(nums2, nums1);
        } 

        int low = 0, high = m;

        while(low <= high) {
            int mid1 = (low+high)/2;
            int mid2 = ((m+n)/2)-mid1;
            double l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            double l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            double r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            double r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1) {
                if((m+n) % 2 == 0) {
                    double median = (Math.max(l1, l2) + Math.min(r1,r2))/2;
                    return median;
                } else {
                    return Math.min(r1, r2);
                }
            } else if( l1 > r2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }
        return -1;
    }
}
