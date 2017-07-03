package hard;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance e = new EditDistance();
		e.minDistance2("a", "b");
	}
	 public int minDistance2(String word1, String word2) {
		 if(word1.length()==0) return word2.length();
	     if(word2.length()==0) return word1.length();
	     int m = word1.length();
	     int n = word2.length();
		 int[] dp = new int[n+1];
		 for(int i=0;i<=m;i++){
			 if(i==0){
				 //convert empty string "" to words2[0] words2[0-1] words2[0...n-1]
				 for(int j=0;j<=word2.length();j++){
					 dp[j] = j;
				 }
			 }else{
				 int pre = dp[0];
				 dp[0] = i;
				 for(int j=1;j<=word2.length();j++){
					 int temp = dp[j];
					 if(word1.charAt(i-1)==word2.charAt(j-1))
					 	dp[j] = pre;
					 else
						 dp[j]= Math.min(pre+1, Math.min(dp[j-1]+1, dp[j]+1));
					 
					 pre = temp;
				 }
			 }
		 }
		 return dp[n];
	 }
	 public int minDistance(String word1, String word2) {
	        if(word1.length()==0) return word2.length();
	        if(word2.length()==0) return word1.length();
	        int m = word1.length();
	        int n = word2.length();
	        int[][] dp = new int[m+1][n+1]; // convert word1[i-1] to word2[j-1]
	        for(int i=0;i<=m;i++){
	            for(int j=0;j<=n;j++){
	                //first row and first col, are not used
	                if(i==0){
	                    //empty string to word2
	                    dp[i][j]=j;
	                }else if(j==0){
	                    dp[i][j]=i;
	                }else{
	                    if(word1.charAt(i-1)==word2.charAt(j-1)){
	                        dp[i][j]=dp[i-1][j-1];
	                    }else{
	                        //3 choices,
	                        //delete word1[i],  the result is dp[i-1][j]+1
	                        //replace word1[i] = word2[j], the result is dp[i-1][j-1]+1
	                        //insert word2[j] to word1[i+1], the result is dp[i][j-1]+1
	                        dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i][j-1]+1,dp[i-1][j]+1));
	                    }
	                }
	                
	            }
	        }
	        return dp[m][n];
	        
	    }

}
