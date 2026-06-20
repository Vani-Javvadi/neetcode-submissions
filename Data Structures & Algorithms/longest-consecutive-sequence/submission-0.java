class Solution {
    public int longestConsecutive(int[] nums) {
        // we will add all elements to set
        // we will try to find starting point of sequence by checking is x-1 present , 
        // if present then current element x is not start of sequence
        // once we find starting one, we will try to find how long it is 
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(nums[i]);
        }
        int lcs = 0;
        for(int i=0; i<n; i++) {
            if(!set.contains(nums[i] - 1)) {
                int x = nums[i], len = 1;
                while(set.contains(x)) {
                    lcs = Math.max(lcs, len++);
                    x = x+1;
                }
            }
        }
        return lcs;
    }
}
