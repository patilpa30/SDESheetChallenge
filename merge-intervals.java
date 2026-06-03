class Solution {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        if( n == 0){
            return new int[0][];
        }
        //sort by start
        Arrays.sort(intervals , (a,b) -> a[0]-b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for(int i = 1; i< n;i++){
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(intervals[i][1],current[1]);
            }
            else{
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
