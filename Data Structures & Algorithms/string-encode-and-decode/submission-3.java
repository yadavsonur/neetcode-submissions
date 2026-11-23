class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String a : strs) {
            // Append length + '#' + the string itself
            sb.append(a.length()).append('#').append(a);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> sol = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            int j = i;
            // Find the '#' delimiter to read the length
            while (str.charAt(j) != '#') {
                j++;
            }
            // Parse the length of the upcoming string
            int length = Integer.parseInt(str.substring(i, j));
            
            // Move past '#' and extract the exact substring
            i = j + 1;
            sol.add(str.substring(i, i + length));
            
            // Advance pointer to the start of the next encoded block
            i += length;
        }
        
        return sol;
    }
}
