class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0;
        int j = 0;
        int room = 0;
        int maxRoom = 0;
        while(i<arr.length && j<dep.length){
            if(arr[i] <= dep[j]){
                room++;
                maxRoom = Math.max(room,maxRoom);
                i++;
            }
            else{
                room--;
                j++;
            }
        }
        return maxRoom;
    }
}
