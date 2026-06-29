class Solution {
    public int findDuplicate(int[] nums) {
        // BF = n^2 
        // sorting - o(nlogn)
        // using map or set - O(N) + sc -  O(N)

        // we will use bit manipulation and check for how many number from 1,n as Y count  and how many numbers in given array has current bit set as X count
        // if count is equal between array and number from 1 -> n , then it is not repeated 
        // else if X > Y means a number was present more than once in array , why X > Y why not X!=Y is if u take below example 
        // 1,2,3,2,2 in this array we have to find , when we check for set bit 3 whose binary value is 1 0 0 - 4 
        // we don't have 4 at all in array , we have it from 1 -> n only , so we will get Y = 1 and X = 0

        // we will check all bit 32 bits - as the number are integers which will have 32 bits
        int n = nums.length, res = 0;
        for(int b=0; b<32; b++) {
            int bit = 1 << b;
            int x = 0, y = 0;
            // check for how many number in the array , the bit was set 
            for(int i=0; i<n; i++) {

                // the bit should be set , say if nums[i] = 3 and bit we are checkig is 2nd position bit so 1 0 & 1 1 gives 1 0 
                if((nums[i] & bit) == bit) {
                    x++;
                }
            }
            // check for the number from 1 to n-1
            for(int i=1; i<n; i++) {
                if((i & bit) == bit) {
                    y++;
                }
            }
            // means the bit was set more than 1 time , means the number having bit set was repeated 
            // so add the bit to result;
            if(x > y) {
                res |= bit;
            }
        }
        return res;

        // tc - 32×O(2n)

    }
}
