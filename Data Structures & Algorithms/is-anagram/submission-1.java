class Solution {
    public boolean isAnagram(String s, String t) {
        int[] first = new int[26];
        int[] second = new int[26];
        for(int i=0; i<s.length();i++){
            int pos = s.charAt(i)-'a';
            first[pos]+=1;
        }
        for(int i=0; i<t.length();i++){
            int pos = t.charAt(i)-'a';
            second[pos]+=1;
        }
        for(int i=0;i<26;i++){
            if(first[i]!=second[i]){
                return false;
            }
        }
        return true;

    }
}
