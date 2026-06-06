class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        if(n == 0){
            return 0;
        }
            
        
        for(int i = 0; i< n ; i++){
            set.add(nums[i]);
        }
        int longest = 1;
        for(Integer it : set){
            if(!set.contains(it - 1)){
                int x = it;
                int cnt = 1;
                while(set.contains(x+1)){
                    x++;
                    cnt++;
                    longest = Math.max(cnt, longest);
                }
            }
        }
        return longest;

    }
}
