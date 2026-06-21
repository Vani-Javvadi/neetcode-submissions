class Solution {

    private void findTarget(int p1, int p2, int target, Set<List<Integer>> set, int[] nums) {
        while(p1 < p2 && p1 < nums.length && p2 >= 0) {
            if(nums[p1] + nums[p2] == target ) {
                set.add(Arrays.asList(nums[p1], nums[p2], -target));
                p1++;
                p2--;
            } else if(nums[p1] + nums[p2] > target) {
                p2--;
                // to reduce the sum move p2 
            } else {
                p1++; 
                // to increase sum move p1 
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            int target = -nums[i];
            findTarget(i+1, n-1, target, set, nums);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> value: set) {
            list.add(value);
        }
        set.clear();
        return list;
    }

    // TC - NlogN - sorting + O(N * N(2 pointer for eacg element))
    // SC - O(N) - hashset 

}
