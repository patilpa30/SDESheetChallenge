class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1],a[1]));
        int size = 0;
        int res = 0;
        for(int[] m : boxTypes){
            if(size + m[0] < truckSize){
                size += m[0];
                res += m[0]*m[1];
            }else{
                int rem = truckSize - size;
                res += rem*m[1];
                break;
            }
        }
        return res;
    }
}
