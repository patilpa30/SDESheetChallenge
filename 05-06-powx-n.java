class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        //x^-2 == 1/x^2 so we convert -2 to 2 to calculate x^2
        if(nn < 0){
            nn = (-1) *nn;
        }

        while(nn >0){
            //odd power
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn-1;
            }
            else{
                x = x*x;
                nn = nn/2;
            }
        }
        if(n < 0){
            ans = (double)(1.0) / (double)(ans);        
        }
        return ans;
    }
}
