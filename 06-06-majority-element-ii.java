class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int cand1 = 0;
        int cand2 = 0;
        int n = nums.length;
        for(int num : nums){
            if(num == cand1){
                cnt1++;
            }
            else if(num == cand2){
                cnt2++;
            }
            else if(cnt1 == 0){
                cand1 = num;
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                cand2 = num;
                cnt2 = 1;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        //check
        cnt1 = 0;
        cnt2 = 0;
        for(int num : nums){
            if(num == cand1){
                cnt1++;
            }
            else if(num == cand2){
                cnt2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(cnt1 > n/3){
            res.add(cand1);
        }
        if(cnt2 > n/3){
            res.add(cand2);
        }
        return res;


    }
}
