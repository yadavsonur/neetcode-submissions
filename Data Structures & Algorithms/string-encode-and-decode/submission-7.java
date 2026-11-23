class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();
        // 2 chars per string header (32-bit length) + actual string characters
        int totalChars = n * 2;
        for (int i = 0; i < n; i++) {
            totalChars += strs.get(i).length();
        }

        char[] buf = new char[totalChars];
        int pos = 0;

        for (int i = 0; i < n; i++) {
            String s = strs.get(i);
            int len = s.length();
            
            // Pack 32-bit length directly into two 16-bit chars (no delimiter needed)
            buf[pos++] = (char) (len >>> 16);
            buf[pos++] = (char) (len & 0xFFFF);
            
            // Native bulk memory copy into the char array
            s.getChars(0, len, buf, pos);
            pos += len;
        }

        return new String(buf);
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int n = str.length();
        int pos = 0;

        while (pos < n) {
            // Unpack 32-bit length in 2 bitwise operations (no loop, no delimiter search)
            int len = (str.charAt(pos) << 16) | str.charAt(pos + 1);
            pos += 2;

            res.add(str.substring(pos, pos + len));
            pos += len;
        }

        return res;
    }
}
