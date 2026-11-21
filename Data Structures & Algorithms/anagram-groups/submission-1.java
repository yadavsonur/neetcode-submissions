class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        Map<String, List<String>> mapp = new HashMap<>();
        for(int i=0; i<n; i++){
            String word = strs[i];
            char[] abc = new char[word.length()];
            for(int j=0; j<word.length(); j++){
                abc[j]= word.charAt(j);
            }

            Arrays.sort(abc);
            String key = Arrays.toString(abc);
            if(mapp.containsKey(key)){
                List<String> xyz = mapp.get(key);
                xyz.add(word);
            }
            else{
                List<String > xyz = new ArrayList();
                xyz.add(word);
                mapp.put(key, xyz );
            }
        }
        List<List<String>> ans = new ArrayList();
        for(List<String> value :mapp.values()){
            ans.add(value);
        }
        return ans;
    }
}
