class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        List<List<Integer>> count = new ArrayList();

        

        for(int i=0; i<strs.length; i++){
            String word = strs[i];
            List<Integer> ans1= new ArrayList<>(26);

            for(int l=0; l<26; l++){
                ans1.add(0);
            }
            for(int j=0; j<word.length();j++){
                int pos=word.charAt(j)-'a';
                int currcount=ans1.get(pos);
                ans1.set(pos,currcount+1);
            }

            if(i==0){
                count.add(ans1);
                List<String> abc = new ArrayList();
                abc.add(word);
                ans.add(abc);
                continue;
            }



            Outer:
            for(int j=0; j<count.size(); j++){

                boolean found = false;

                List<Integer> currlist=count.get(j);
                for(int k=0; k<26; k++){
                    if(!currlist.get(k).equals(ans1.get(k))){
                        break;
                    }
                    if(k==25){
                        ans.get(j).add(word);
                        break Outer;
                    }
                    
                }
                if(j==count.size()-1){
                    count.add(ans1);
                    List<String> xyz = new ArrayList<>();
                    xyz.add(word);

                    ans.add(xyz);
                    break;
                }
            }
        }

        return ans;
        
    }
}
