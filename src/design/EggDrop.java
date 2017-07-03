package design;

public class EggDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eggDropDP(5,2));
	}
	//n eggs and k floor
	public static int eggDrop(int k, int n){
		//only one egg can be used
		if(n<=1) return k;
		//only one or zero floor
		if(k<=1) return k;
		int[][] eggFloor  = new int[n+1][k+1];
		int min = Integer.MAX_VALUE;
		for(int x=1;x<=k;x++){
			int max = Math.max(eggDrop(x-1,n-1), eggDrop(k-x,n));
			min = Math.min(min, max);
		}
		System.out.println(" egg : "+n +" floor:  "+k + "  result: "+min+1);
		return min+1;
	}
	//n eggs and k floor
		public static int eggDropDP(int k, int n){
			//only one egg can be used
			if(n<=1) return k;
			//only one or zero floor
			if(k<=1) return k;
			int[][] eggFloor  = new int[n+1][k+1];
			for(int i=0;i<=k;i++){
				eggFloor[1][i]=i;
			}
			for(int i=0;i<=n;i++){
				eggFloor[i][1]=1;
				eggFloor[i][0]=0;
			}
			int min = Integer.MAX_VALUE;
			for(int i=2;i<=n;i++){
				for(int j=2;j<=k;j++){
					for(int x=1;x<=k;x++){
						int max = Math.max(eggFloor[n-1][x-1], eggFloor[n][k-x]);
						eggFloor[i][j] = 1+Math.min(min, max);
					}
				}
			}
			return eggFloor[n][k];
		}
}
