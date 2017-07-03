package microSoftOA;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//greedy 
	//
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //gereral check ,if sum of gas is samller than sum of cost
    	//it must can not achive that
    	int left = 0;
    	int start = 0;
    	for(int i=0;i<gas.length;i++){
    		left = left +gas[i]-cost[i];
    		if(left<=0){
    			start = i+1;
    		}
    	}
    }
	

}
