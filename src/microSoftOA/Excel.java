package microSoftOA;
import java.util.*;
public class Excel {
	private int[][] C;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Excel(int H, char W) {
        C = new int[H+1][W+1];
    }
    
    public void set(int r, char c, int v) {
        C[r][c]=v;
    }
    
    public int get(int r, char c) {
        return C[r][c];
    }
    
    public int sum(int r, char c, String[] strs) {
       
    }
    public List<int[]> merge(String[] strs) {
        List<int[]> res = new ArrayList<int[]>();        //convert to 2 elements arry for each string
        List<Range> ranges = new ArrayList<Range>();
        for(int i=0;i<strs.length;i++){
        	String[] str = strs[i].split(":");
        	if(str.length==2){
        		ranges.add(parseString(str[0],str[1]));
        	}else{
        		ranges.add(parseString(str[0],str[0]));
        	}
        }
       //merge
        Collections.sort(ranges,(a,b)->);
	   return res;
    }
    public class Range{
    	int rowStart;
    	int rowEnd;
    	int  colStart;
    	int colEnd;
    	public Range(int rowStart,int rowEnd,int colStart,int colEnd){
    		this.rowStart=rowStart;
    		this.rowEnd = rowEnd;
    		this.colStart = colStart;
    		this.colEnd = colEnd;
    	}
    }
    public Range parseString(String start, String end){//A1
    	int rowStart = Integer.valueOf(start.substring(1,start.length()));
    	int rowEnd =  start.charAt(0);
    	int colStart = Integer.valueOf(end.substring(1,end.length()));
    	int colEnd = start.charAt(0);
    	return new Range(rowStart,rowEnd,colStart,colEnd);
    }

}
