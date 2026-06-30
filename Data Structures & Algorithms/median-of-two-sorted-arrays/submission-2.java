class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TC - (m+n)/2
        // I know where median lies, it lies in (m+n)/2 , if combined two array size is l 
        // if l is even median will be - l/2, (l/2)+1 
        // if l is odd then median will be - (l/2)+1

        // take 2 pointers p1, p2 
        // when cnt - to track number of element we have traverses, we will traverl until cnt <= (m+n)/2 
        // once the cnt become (m+n)/2 it tells that we have reached  median 
        // so we will return median , but track between p1 and p2 we will take curr variable which stores the current value either p1's or p2's based on conditions 
        // for even length we need 2 medians , so we will track prev element as well 

        double cnt = 0, prev = 0;
        int n = nums1.length, m = nums2.length;
        int p1=0, p2=0, curr = 0;
        while(cnt <= (m+n)/2) {
            prev = curr;
            // when p2 reaces end don't check condition 
            if(p1<n && (p2>=m || nums1[p1] < nums2[p2])) {
                curr = nums1[p1];
                p1++;
            } else {
                curr = nums2[p2];
                p2++;
            }
            cnt++;
        }
        if((m+n)%2 == 0) {
            return (curr+prev)/2;
        }
        return curr; 
        // TC - (M+N)/2;
    }
}
