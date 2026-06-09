class Solution {
    public long subarrayXor(int nums[], int target) {
        
        // Map<PrefixXOR, Frequency>
        Map<Integer, Integer> freq = new HashMap<>();
        
       
        // (handles subarrays starting from index 0)
        freq.put(0, 1);
        
        int prefixXor = 0;
        long count = 0;
        
       
        for (int num : nums) {
           
            prefixXor ^= num;
            
            
            int requiredXor = prefixXor ^ target;
            
            
            if (freq.containsKey(requiredXor)) {
                count += freq.get(requiredXor);
            }
            
            
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        
        return count;
    }
}
