class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int val = 0;
        for(int i = 0; i< nums.length;i++){
            if(cnt == 0){
                val = nums[i];
                cnt++;
                continue;
            }
            if(val != nums[i]){
                cnt--;
            }
            else{
                cnt++;
            }

        }
        if(cnt > 0){
            return val;
        }
        return -1;
        
    }
}
