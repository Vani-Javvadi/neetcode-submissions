class Solution {
    public int reverseBits(int n) {
        int currentpow=0, res=0;
        for(int i=0; i<32; i++) {
            int currentbit = (n & 1);
            res = res | (currentbit * (1 << (31-i)));
            n = n >>> 1;
        }
        return res;
    }
}
