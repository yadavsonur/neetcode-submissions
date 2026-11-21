

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            private List<List<String>> ans;

            @Override
            public List<String> get(int index) {
                if (ans == null) init();
                return ans.get(index);
            }

            @Override
            public int size() {
                if (ans == null) init();
                return ans.size();
            }

            private void init() {
                ans = new ArrayList<>();
                Map<String, List<String>> map = new HashMap<>(strs.length);

                for (String word : strs) {
                    char[] count = new char[26];
                    for (int i = 0; i < word.length(); i++) {
                        count[word.charAt(i) - 'a']++;
                    }
                    String key = new String(count);

                    List<String> group = map.get(key);
                    if (group == null) {
                        group = new ArrayList<>();
                        map.put(key, group);
                        ans.add(group);
                    }
                    group.add(word);
                }
            }
        };
    }
}
