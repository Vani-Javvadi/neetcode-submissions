class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int p1 = 0, p2 = n - 1;

        while (p1 != p2 && p1 < n && p2 >= 0) {
            Character l = s.charAt(p1);
            Character r = s.charAt(p2);
            if (Character.toLowerCase(l) ==  Character.toLowerCase(r)) {
                p1++;
                p2--;
            } else if(!Character.isLetterOrDigit(l)) {
                p1++;
            } else if(!Character.isLetterOrDigit(r)){
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }
}