class Solution {

    public String encode(List<String> strs) {
        // we will ge a though like , we can use space as delimiter between string and we can encode , but what if space is also a character in the string , so to get rid of that we can use length+delimiter to separte the string so that we can decode them easily , so when we ecnode will add string length and delimiter as | followed by string 

        // example - 5|hello5|world4|java
        int n = strs.size();
        StringBuilder encoded = new StringBuilder();
        for(int i=0; i<n; i++) {
            String str = strs.get(i);
            int len = str.length();
            encoded.append(len).append('#');
            for(int j=0; j<len; j++) {
                encoded.append(str.charAt(j));
            }
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        // when we decode , we will read the first 2 character , then go through the string upto the length define and add it to the list while decoding ,
        int n = str.length(), i=0;
        while(i<n) {
            int len = 0;
            while(str.charAt(i) != '#') {
                len = (len*10) + str.charAt(i) - '0';
                i++; 
            }
            i++;
            StringBuilder string = new StringBuilder();
            while(len != 0 && i < n) {
                string.append(str.charAt(i));
                len--;
                i++;
            }
            res.add(string.toString());
        }
        return res;
        
    }
}
