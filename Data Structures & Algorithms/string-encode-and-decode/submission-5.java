class Solution {

    public String encode(List<String> strs) {
        // 1. Pre-calculate exact capacity to prevent StringBuilder resizing
        int totalLength = 0;
        for (int i = 0; i < strs.size(); i++) {
            int len = strs.get(i).length();
            // Length of digits + 1 for '#' + actual string length
            totalLength += (len == 0 ? 1 : (int) Math.log10(len) + 1) + 1 + len;
        }

        StringBuilder sb = new StringBuilder(totalLength);
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int n = str.length();
        int i = 0;

        while (i < n) {
            // 2. Parse length inline without creating temporary substrings
            int length = 0;
            while (str.charAt(i) != '#') {
                length = length * 10 + (str.charAt(i) - '0');
                i++;
            }
            
            // Move past '#'
            i++; 
            
            // Extract the exact string and jump pointer forward
            res.add(str.substring(i, i + length));
            i += length;
        }

        return res;
    }
}
