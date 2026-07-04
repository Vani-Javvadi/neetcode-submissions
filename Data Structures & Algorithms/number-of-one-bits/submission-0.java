class Solution {
    public int hammingWeight(int n) {
        int cnt_1=0;
        while(n != 0) {
            if((n & 1) != 0) {
                cnt_1++;
            }
            n = n >> 1;
        }
        return cnt_1;
    }
}
