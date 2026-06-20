class Solution {
    int f(int ind , int T , int[] coins, int[][] dp){
        if(ind == 0){
            if(T % coins[0] == 0){
                return T/coins[0];
            }
            return (int)1e9;
        }
        if(dp[ind][T] != -1){
            return dp[ind][T];
        }
        int notTake = 0 + f(ind-1, T, coins, dp);
        int take = (int)1e9;
        if(coins[ind] <= T){
            take = 1 + f(ind , T-coins[ind] , coins, dp);
        }

        return dp[ind][T] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row , 0);
        }
        for(int T = 0 ; T<= target ; T++){
            if(T % coins[0] ==0){
                dp[0][T] = T/coins[0];
            }
            else{
                dp[0][T] = (int)1e9;
            }
        }

        for(int ind = 1; ind < n ; ind++){
            for(int T = 0; T <= target;T++){
                int notTake = 0 + dp[ind-1][T];
                int take = (int)1e9;
                if(coins[ind] <= T){
                    take = 1 + dp[ind][T-coins[ind]];
                }

                dp[ind][T] = Math.min(take, notTake);
            }
        }



        int ans =  dp[n-1][target];

        if(ans >= 1e9){
            return -1;
        }
        return ans;
    }
}
