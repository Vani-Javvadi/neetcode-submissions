class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we know like in 1 hr , the koko can target one pile like eat pile ,
        //  if it completed 2 banans in a pile in 1hr , in that 1 hr it should not touch another pile 
        // means in a hour it can eat banans from one pile omly 

        // so we will know min muber of banans it can eat is 1 , the possible min value is 1 / hr
        // maximum banans it can eat is maximum pile from array 
        // our search space is 1 to max pile 
        // we will get value from 1 -> Max a mid value, check if it is valid - mid 

        // If a speed k is sufficient, then every speed > k is also sufficient.
        // If a speed k is not sufficient, then every speed < k is also not sufficient.
        
        // if valid we will try to find the even more min exist or not - mid-1  
        // not valid means we have to increase the banans count - mid + 1 

        int n = piles.length;
        int high = 1, low=1; 
        // find max no.of bananas pile 
        for(int i=0; i<n; i++) {
            high = Math.max(high, piles[i]);
        } 
        int min = high; 
        while(low <= high) {
            int mid = (low+high)/2;
            if(cankokoEatBanans(mid, h, piles)) {
                min = mid;
                high = mid-1;
            } else {
                low = mid+1; 
            }
        }
        return min;
    }

    private boolean cankokoEatBanans(int banansCount, int h, int[] piles) {
        int n = piles.length;
        int noOfHoursToEat = 0; 
        for(int i=0; i<n; i++) {
            if(piles[i] <= banansCount) {
                noOfHoursToEat++;
            } else {
                noOfHoursToEat += (piles[i] / banansCount);
                if(piles[i] % banansCount != 0) {
                    noOfHoursToEat += 1;
                }
            }
        }
        return noOfHoursToEat <= h;
    }
}
