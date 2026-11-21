class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n = numbers.length;
        //for(int i = 0; i<n; i++){
            // int search = target-numbers[i];
            // int low = i+1;
            // int high = n-1;
            // while(low<=high){
            //     int mid=(low+high)>>1;
            //     if(numbers[mid]==search){
            //         ans[0]=i+1;
            //         ans[1]=mid+1;
            //         return ans;
            //     }
            //     else if(numbers[mid]<search){
            //         low=mid+1;
            //     }
            //     else{
            //         high = mid-1;
            //     }
            // }
        int left = 0;
        int right = n-1;
        while(numbers[left]+numbers[right]!=target){
            if(target<numbers[left]+numbers[right]){
                right--;
            }
            else{
                left++;
            }
        }
        ans[0]=left+1;
        ans[1]= right+1;
        return ans;
            
        }
        
    }

