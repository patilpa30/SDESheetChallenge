class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        
        List<int[]> intervals = new ArrayList<>();
        
        for(int i = 0 ; i< start.length;i++){
            intervals.add(new int[] {start[i], end[i]});
        }
        
        intervals.sort(Comparator.comparing(a -> a[1]));
        int cnt = 0;
        int lastEnd = -1;
        for(int[] m : intervals){
            if(m[0] > lastEnd){
                cnt++;
                lastEnd = m[1];
            }
        }
        return cnt;
    }
}
