class Solution {
    ArrayList<Integer> findTwoElement(int nums[]) {
        // code here
        boolean[] arr = new boolean[nums.length + 1];
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : nums){
            if(arr[num] == true){
                res.add(num);
            }
            else{
                arr[num] = true;
            }
        }
        for(int i = 1; i <= nums.length;i++){
            if(arr[i] == false){
                res.add(i);
                break;
            }
        }
        return res;
        
        
        
    }
} 
/*
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int missing = 0;
        int repeating = 0;
        //expected
        long s = (long) n*(n+1)/2;
        long ssq = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        //actual
        for(int i = 0; i< n;i++){
            s-=arr[i];
            ssq -= (long)arr[i]*arr[i];
        }
        //  x = missing, y = repeating
        // s = x - y ---(i)
        // ssq = x^2 - y^2 = (x - y)(x + y) = s * (x + y)
        // => x + y = ssq / s ....(ii)
        // add i and ii 
        // => x = (s + ssq / s) / 2
        // => y = x - s
        missing = (int)((s + ssq / s) / 2);
        repeating = (int) (missing - s);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(repeating);
        res.add(missing);
        return res;
        
        
        
    }
}
*/
