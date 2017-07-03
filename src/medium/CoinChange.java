package medium;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins={2};
		coinChange(coins,3);
	}
	public static int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length<=0) return -1;
        Arrays.sort(coins);
        if(amount<coins[0]) return -1;
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
        	dp[i]=-1;
        }
        for(int i=1;i<=amount;i++){
        	for(int coin:coins){
        		if(i==coin){
        			dp[i]=1;
        			break;
        		}else if(i>coin&&dp[i-coin]!=-1){//If it is -1, then it is not meningful for me, don't need to care that coin
        			if(dp[i]==-1) dp[i]=1+dp[i-coin];
        			else dp[i]=Math.min(dp[i], dp[i-coin]+1);
        		}
        	}
        }
        return dp[amount];
    }
	

}
