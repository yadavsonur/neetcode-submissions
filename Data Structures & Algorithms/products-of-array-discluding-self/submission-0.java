class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int complete=1;
        int zerocount=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                zerocount++;
            }
            else{
                complete*=nums[i];
            }
        }
        int[] ans = new int[n];

        if(zerocount<1){
            for(int i=0; i<n; i++){
                ans[i]=complete/nums[i];
            }
        }
        else if(zerocount==1){
            for(int i=0; i<n;i++){
                if(nums[i]==0){
                    ans[i]=complete;
                }
                else{
                    ans[i]=0;
                }
            }
        }
        else{
            for(int i=0; i<n;i++){
                ans[i]=0;
            }
        }

        
        

        return ans;
        
    }
}  
