class Solution {

    private void findTarget(int p1, int p2, int target, List<List<Integer>> list, int[] nums) {
        while(p1 < p2) {
            if(nums[p1] + nums[p2] == target ) {
                list.add(Arrays.asList(nums[p1], nums[p2], -target));
                p1++;
                p2--;
                // to skip duplicates  - [-2,0,0,2,2]
                while (p1 < p2 && nums[p1] == nums[p1 - 1]) {
                    p1++;
                }
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
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            // to skip dups - [-2,0,0,2,2] 
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            findTarget(i+1, n-1, target, list, nums);
        }

        return list;
    }

    // TC - NlogN - sorting + O(N * N(2 pointer for eacg element))
    // SC - O(N) - hashset 

}
