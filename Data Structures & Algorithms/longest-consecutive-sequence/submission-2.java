class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length<1){
            return 0;
        }
        Arrays.sort(nums);
        int maxlength=1;
        int currentlength=1;
        int currentchecker=0;
        for(int i=1; i<nums.length; i++){
            if(nums[currentchecker]==nums[i]){
                continue;
            }
            else if(nums[currentchecker]+1==nums[i]){
                currentlength++;
                currentchecker=i;
            }
            else{
                currentlength=1;
                currentchecker=i;
            }

            maxlength=Math.max(currentlength,maxlength);
        }
        return maxlength;
    }
}
