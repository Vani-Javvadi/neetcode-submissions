class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i=1; i<=n; i++) {
            // take each number find if Left significant bit is 1 
            // after checking do right shft to move to next bit in number 

            int num = i, cnt = 0;
            while(num != 0) {
                if((num & 1) != 0) {
                    cnt++;
                }
                num = num >> 1;
            }
            res[i] = cnt; 
        }
        return res;
    }
}
