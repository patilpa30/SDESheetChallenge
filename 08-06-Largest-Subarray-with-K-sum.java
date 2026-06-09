// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        //(prefix_sum -> first_occurrence_index)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;
        
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            // If the sum itself is k, the subarray is from index 0 to i
            if (sum == k) {
                maxLen = i + 1;
            }
            
          
            if (map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, i - map.get(sum-k));
            } 
                
            map.putIfAbsent(sum,i);
        }
        
        return maxLen;
    }
}
