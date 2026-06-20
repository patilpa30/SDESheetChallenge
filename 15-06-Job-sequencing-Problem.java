class Solution {
    class Job{
        int id;
        int deadline;
        int profit;
        Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    int[] parent;
    
    int find(int val){
        if(val == parent[val]){
            return val;
        }
        return parent[val] = find(parent[val]);
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        List<Job> arr = new ArrayList<>();
        int maxDeadline = 0;
        
        for(int i = 0; i<n;i++){
            arr.add(new Job(i+1, deadline[i], profit[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        
        Collections.sort(arr, (a,b) -> b.profit - a.profit);
        
        parent = new int[maxDeadline+1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }
        
        int count = 0;
        int maxProfit = 0;
        
        for(int i = 0; i<n;i++){
            Job curr = arr.get(i);
            
            int available = find(curr.deadline);
            
            if(available > 0){
                parent[available] = find(available - 1);
                count++;
                maxProfit += curr.profit;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(maxProfit);
        return res;
        
    }
}
